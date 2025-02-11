package sat.pract.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sat.pract.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
