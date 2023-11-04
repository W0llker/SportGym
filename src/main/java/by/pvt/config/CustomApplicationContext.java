package by.pvt.config;

//public class CustomApplicationContext {
    // TODO: 23.10.2023 перешел на Spring
//    private static ApplicationContext applicationContext;
//    private final VisitsService visitsService;
//    private final SportOfficeService sportOfficeService;
//    private final static StandardServiceRegistryBuilder service;
//    private final static Configuration configuration;
//    static {
//        Properties properties = new Properties();
//
//
//
//        properties.setProperty("hibernate.cache.use_second_level_cache", "true");
//        properties.setProperty("hibernate.cache.use_query_cache", "true");
//
//        properties.setProperty("hibernate.cache.region.factory_class","org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
//        properties.setProperty("net.sf.ehcache.configurationResourceName", "META-INF/config/ehcache.xml");
//
//        configuration = new Configuration();
//        configuration.setProperties(properties);
//        configuration.addAnnotatedClass(User.class);
//        configuration.addAnnotatedClass(Activities.class);
//        configuration.addAnnotatedClass(PremiumUser.class);
//        configuration.addAnnotatedClass(Visits.class);
//        configuration.addAnnotatedClass(Employee.class);
//        configuration.addAnnotatedClass(Guest.class);
//        configuration.addAnnotatedClass(SportOfficeWithSubSelect.class);
//        configuration.addAnnotatedClass(SportOffice.class);
//        service = new StandardServiceRegistryBuilder();
//        service.applySettings(properties);
//    }
//    private final EntityManager entityManager;
//    private final UserService userService;
//    private ApplicationContext () {
//        entityManager = Persistence.createEntityManagerFactory("UserJpa").createEntityManager();
//        sportOfficeService = new SportOfficeServiceImpl(new SportOfficeHibernate());
//        userService = new UserServiceImpl(new UserHibernate());
//        visitsService = new VisitsServiceImpl(new VisitsHibernate());
//    }
//    public static synchronized ApplicationContext getInstance() {
//        if(applicationContext == null) {
//            applicationContext = new ApplicationContext();
//            return applicationContext;
//        }
//        return applicationContext;
//    }
//    public static SessionFactory getSessionFactory() {
//        SessionFactory sessionFactory = configuration.buildSessionFactory(service.build());
//        return sessionFactory;
//    }
//
//    public VisitsService getVisitsService() {
//        return visitsService;
//    }
//
//    public UserService getUserService() {
//        return userService;
//    }
//
//    public EntityManager getEntityManager() {
//        return entityManager;
//    }
//
//    public SportOfficeService getSportOfficeService() {
//        return sportOfficeService;
//    }
//}
