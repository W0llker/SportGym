package by.pvt.repository.hibernate;

import by.pvt.entity.User;
import by.pvt.entity.testentity.PremiumUser;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import by.pvt.repository.UserDao;

import java.util.List;
//@Repository
//@RequiredArgsConstructor
//public class UserHibernate implements UserDao {
//    private final SessionFactory sessionFactory;
//
//    @Override
//    public void add(User user) {
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        session.persist(user);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public List<PremiumUser> findPremium() {
//        Session session = sessionFactory.openSession();
//        List<PremiumUser> pu = session.createQuery("select pu from PremiumUser pu").getResultList();
//        session.close();
//        return pu;
//    }
//
//    @Override
//    public User findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public List<User> getAllUser() {
//        return null;
//    }
//}
