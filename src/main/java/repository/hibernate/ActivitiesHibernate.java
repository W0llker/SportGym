package repository.hibernate;

import config.ApplicationContext;
import entity.Activities;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.ActivitiesDao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ActivitiesHibernate implements ActivitiesDao {
    private final SessionFactory sessionFactory;

    public ActivitiesHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Activities activities) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Activities findById(Long id) {
        return null;
    }


    @Override
    public List<Activities> getAllUser() {
        return null;
    }

    @Override
    public Long getLowPrice() {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Long> activitiesCriteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Employee> activitiesRoot = activitiesCriteriaQuery.from(Employee.class);
        activitiesCriteriaQuery.select(criteriaBuilder.min(activitiesRoot.get("cost")));

        Session session = sessionFactory.openSession();
        return session.createQuery(activitiesCriteriaQuery).getSingleResult();
    }
}
