package by.pvt.repository;

import by.pvt.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee,Long> {
    @Query("select max(e.salary),e from Employee e")
    Employee getMaxSalary();
    @Query("select min(e.salary),e from Employee e")
    Employee getEmployeeMinSalary();
    @Query("select sum(e.salary) as sum from Employee e")
    BigDecimal getExpenses();
}
