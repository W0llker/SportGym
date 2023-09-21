package repository.hibernate;

import config.ApplicationContext;
import entity.User;
import entity.testentity.PremiumUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.UserDao;

import java.util.List;

public class UserHibernate implements UserDao {
    private final SessionFactory sessionFactory;

    public UserHibernate() {
        sessionFactory = ApplicationContext.getSessionFactory();
    }

    @Override
    public void add(User user) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PremiumUser> findPremium() {
        Session session = sessionFactory.openSession();
        List<PremiumUser> pu = session.createQuery("select pu from PremiumUser pu").getResultList();
        session.close();
        return pu;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}
