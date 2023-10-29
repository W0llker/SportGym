package repository.hibernate;

import config.ApplicationContext;
import entity.Guest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import repository.GuestDao;

import java.util.List;
import java.util.Queue;

public class GuestHibernate implements GuestDao {
    private final SessionFactory sessionFactory;

    public GuestHibernate() {
        this.sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(Guest guest) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(guest);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void remove(Long id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Guest guest = session.find(Guest.class,id);
        session.remove(guest);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Guest findById(Long id) {
        Session session = sessionFactory.openSession();
        Guest guest = session.find(Guest.class,id);
        session.close();
        return guest;
    }
    public List<Guest> findByName(String name) {
        Session session = sessionFactory.openSession();
        Query queue = session.createQuery("select s from Guest s where s.name =:name");
        queue.setParameter("name",name);
        return queue.getResultList();
    }

    @Override
    public List<Guest> getAllGuest() {
        Session session = sessionFactory.openSession();
        List<Guest> guestList = session.createQuery("select s from Guest s").getResultList();
        session.close();
        return guestList;
    }
}
