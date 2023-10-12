package repository.hibernate;

import config.ApplicationContext;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.EmployeeDao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
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
    public Employee findMaxSalary() {
        Session session = sessionFactory.openSession();
        List<Employee> employee = session.createQuery("select c from Employee c where c.salary= (select max(salary) from Employee e)").getResultList();
        return employee.get(0);
    }

    @Override
    public Employee findMinSalary() {
        Session session = sessionFactory.openSession();
        return (Employee) session.createQuery("select c from Employee c where c.salary= (select min(salary) from Employee e)").getResultList().get(0);
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.openSession();
        List<Employee> employeeList = session.createQuery("select e from Employee e").getResultList();
        session.close();
        return employeeList;
    }
    @Override
    public List<Employee> getAllEmployeeCriteria() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Employee> employeeCriteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = employeeCriteriaQuery.from(Employee.class);
        employeeCriteriaQuery.select(employeeRoot);

        Session session = sessionFactory.openSession();
        return session.createQuery(employeeCriteriaQuery).getResultList();
    }

    @Override
    public BigDecimal getExpenses() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select sum(e.salary) as sum from Employee e");
        return (BigDecimal) query.getSingleResult();
    }
}
