package by.pvt.service.impl;

import by.pvt.service.EmployeeService;
import by.pvt.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.pvt.repository.EmployeeDao;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private final EmployeeDao employeeDao;

    @Override
    public void add(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        var employee = Optional.of(employeeDao.findById(id).orElseThrow(() -> new RuntimeException("Нету пользователя с таким id " + id)));

        return employee.get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeDao.findAll();
    }
}
