package by.pvt.service;

import by.pvt.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void add(Employee employee);
    void delete(Long id);
    Employee findById(Long id);
    List<Employee> getAllEmployee();
}
