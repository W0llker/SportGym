package config;

import repository.jpa.UserJpa;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final EntityManager entityManager;
    private final UserService userService;
    private ApplicationContext () {
        entityManager = Persistence.createEntityManagerFactory("UserJpa").createEntityManager();
        userService = new UserServiceImpl(new UserJpa());
    }
    public static synchronized ApplicationContext getInstance() {
        if(applicationContext == null) {
            applicationContext = new ApplicationContext();
            return applicationContext;
        }
        return applicationContext;
    }

    public UserService getUserService() {
        return userService;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
