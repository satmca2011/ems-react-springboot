package sat.pract.ems.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sat.pract.ems.dto.EmployeeDto;
import sat.pract.ems.entity.Employee;
import sat.pract.ems.exception.ResourceNotFoundException;
import sat.pract.ems.mapper.EmployeeMapper;
import sat.pract.ems.repository.EmployeeRepository;
import sat.pract.ems.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exist with the given id: "+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDtoRequest) {
        Employee dbEmployee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee is not found with the id: "+employeeId)
        );

        dbEmployee.setFirstName(employeeDtoRequest.getFirstName());
        dbEmployee.setLastName(employeeDtoRequest.getLastName());
        dbEmployee.setEmail(employeeDtoRequest.getEmail());
        dbEmployee.setMobileNumber(employeeDtoRequest.getMobileNumber());
        Employee savedEmployee = employeeRepository.save(dbEmployee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee dbEmployee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee is not found with the id: "+employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
