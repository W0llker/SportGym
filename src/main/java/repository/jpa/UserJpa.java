package repository.jpa;

import config.ApplicationContext;
import entity.User;
import entity.testentity.PremiumUser;
import repository.UserDao;

import javax.persistence.EntityManager;
import java.util.List;

public class UserJpa implements UserDao {
    @Override
    public void add(User user) {
        EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    public User findById(Long id) {
        EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();
        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public List<PremiumUser> findPremium() {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        EntityManager entityManager = ApplicationContext.getInstance().getEntityManager();
        List<User> users = entityManager.createQuery("SELECT s FROM User s").getResultList();
        return users;
    }
}
