package sat.pract.ems.mapper;

import sat.pract.ems.dto.EmployeeDto;
import sat.pract.ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        //return null;
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getMobileNumber()
        );
    }

    public  static Employee mapToEmployee(EmployeeDto employeeDto){
        //return null;
        return new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getMobileNumber());
    }
}
