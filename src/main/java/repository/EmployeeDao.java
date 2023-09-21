package repository;

import entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void add(Employee employee);
    void delete(Long id);
    Employee findById(Long id);
    List<Employee> getAllEmployee();
}
