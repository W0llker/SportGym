package repository.hibernate;

import config.ApplicationContext;
import entity.Visits;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.VisitsDao;


public class VisitsHibernate implements VisitsDao {
    private final SessionFactory sessionFactory;

    public VisitsHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Visits visits) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(visits);
        session.getTransaction().commit();
        session.close();
    }
}
