package service.impl;

import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.EmployeeDao;
import service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = employeeDao.findById(id);
        if(employee == null) {
            throw new RuntimeException();
        }
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }
}
