package repository;

import entity.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeDao {
    void add(Employee employee);
    Employee findMaxSalary();
    Employee findMinSalary();
    void delete(Long id);
    Employee findById(Long id);
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeCriteria();
    BigDecimal getExpenses();
}
