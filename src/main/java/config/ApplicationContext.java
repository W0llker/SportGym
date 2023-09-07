package config;

import entity.Activities;
import entity.SportOffice;
import entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import repository.hibernate.SportOfficeHibernate;
import repository.jpa.UserJpa;
import service.SportOfficeService;
import service.UserService;
import service.impl.SportOfficeServiceImpl;
import service.impl.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Properties;

public class ApplicationContext {
    private static ApplicationContext applicationContext;
    private final SportOfficeService sportOfficeService;
    private final static StandardServiceRegistryBuilder service;
    private final static Configuration configuration;
    static {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.use_sql_comments","true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.connection.driver.class","org.postgresql.Driver");
        properties.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/testdb");
        properties.setProperty("hibernate.connection.username","postgres");
        properties.setProperty("hibernate.connection.password","nik981ita413");
        properties.setProperty("hibernate.show_sql","true");
        configuration = new Configuration();
        configuration.setProperties(properties);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Activities.class);
        configuration.addAnnotatedClass(SportOffice.class);
        service = new StandardServiceRegistryBuilder();
        service.applySettings(properties);
    }
    private final EntityManager entityManager;
    private final UserService userService;
    private ApplicationContext () {
        entityManager = Persistence.createEntityManagerFactory("UserJpa").createEntityManager();
        sportOfficeService = new SportOfficeServiceImpl(new SportOfficeHibernate());
        userService = new UserServiceImpl(new UserJpa());
    }
    public static synchronized ApplicationContext getInstance() {
        if(applicationContext == null) {
            applicationContext = new ApplicationContext();
            return applicationContext;
        }
        return applicationContext;
    }
    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = configuration.buildSessionFactory(service.build());
        return sessionFactory;
    }
    public UserService getUserService() {
        return userService;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public SportOfficeService getSportOfficeService() {
        return sportOfficeService;
    }
}
