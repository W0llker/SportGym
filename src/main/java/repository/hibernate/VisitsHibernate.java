package repository.hibernate;

import config.ApplicationContext;
import entity.Visits;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import repository.VisitsDao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;


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

    @Override
    public BigDecimal getAmountData(LocalDate start, LocalDate end) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select sum(c.amount) as sum from Visits c where c.dateVisits>:dateStart and c.dateVisits<:dateEnd");
        query.setParameter("dateStart",start);
        query.setParameter("dateEnd",end);
        return (BigDecimal) query.getSingleResult();
    }
}
