package repository.hibernate;

import config.ApplicationContext;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.EmployeeDao;

import java.util.List;

public class EmployeeHibernate implements EmployeeDao {
    private final SessionFactory sessionFactory;
    public EmployeeHibernate() {
        sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Employee employee) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(employee);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.remove(session.find(Employee.class,id));
        session.getTransaction().begin();
        session.close();
    }

    @Override
    public Employee findById(Long id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.find(Employee.class,id);
        session.close();
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.openSession();
        List<Employee> employeeList = session.createQuery("select e from Employee e").getResultList();
        session.close();
        return employeeList;
    }
}
