package by.pvt.repository.jpa;

import by.pvt.entity.User;
import by.pvt.entity.testentity.PremiumUser;
import by.pvt.repository.UserDao;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import java.util.List;
//@Repository
//public class UserJpa implements UserDao {
//    EntityManager entityManager;
//
//    @Override
//    public void add(User user) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(user);
//        entityManager.getTransaction().commit();
//    }
//
//    @Override
//    public void delete(Long id) {
//        User user = entityManager.find(User.class,id);
//        entityManager.remove(user);
//    }
//
//    @Override
//    public User findById(Long id) {
//        User user = entityManager.find(User.class,id);
//        return user;
//    }
//
//    @Override
//    public List<PremiumUser> findPremium() {
//        return null;
//    }
//
//    @Override
//    public List<User> getAllUser() {
//        List<User> users = entityManager.createQuery("SELECT s FROM User s").getResultList();
//        return users;
//    }
//}
