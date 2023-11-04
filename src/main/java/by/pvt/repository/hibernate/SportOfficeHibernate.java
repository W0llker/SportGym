package by.pvt.repository.hibernate;

import by.pvt.entity.testentity.SportOfficeWithSubSelect;
import by.pvt.repository.SportOfficeDao;
import by.pvt.entity.Activities;
import by.pvt.entity.SportOffice;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Method;
import java.util.List;
//@Repository
//@RequiredArgsConstructor
//public class SportOfficeHibernate implements SportOfficeDao {
//    private final SessionFactory sessionFactory;
//
//    @Override
//    public void edit(Long id, String param, String value) {
//        try {
//            Session session = sessionFactory.openSession();
//            session.getTransaction().begin();
//            SportOffice sportOffice = session.find(SportOffice.class, id);
//            Method method = sportOffice.getClass().getDeclaredMethod("set" + param.substring(0, 1).toUpperCase() + param.substring(1), String.class);
//            method.setAccessible(true);
//            method.invoke(sportOffice, value);
//            method.setAccessible(false);
//            session.update(sportOffice);
//            session.getTransaction().commit();
//            session.close();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void add(SportOffice sportOffice) {
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        session.persist(sportOffice);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    public void addAndUpdate(Long id, String inventoryNumber) {
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        SportOffice sportOffice = session.find(SportOffice.class, id);
//        session.detach(sportOffice);
//        sportOffice.setInventoryNumber(inventoryNumber);
//        sportOffice.setId(null);
//        session.persist(sportOffice);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public void delete(Long id) {
//        Session session = sessionFactory.openSession();
//        session.getTransaction().begin();
//        session.delete(session.find(SportOffice.class, id));
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public SportOffice findById(Long id) {
//        Session session = sessionFactory.openSession();
//        SportOffice sportOffice = session.find(SportOffice.class, id);
//        session.close();
//        return sportOffice;
//    }
//
//    @Override
//    public void getAllOfficesAndAllActivitiesAndOfficesById(Long id) {
//        Session session = sessionFactory.openSession();
//        List<SportOffice> sportOffices = session.createQuery("select s from SportOffice s").getResultList();
//        List<Activities> activities = session.createQuery("select a from Activities a").getResultList();
//        SportOffice sportOffice = session.find(SportOffice.class,id);
//    }
//
//    @Override
//    public List<SportOfficeWithSubSelect> findSmallPremises() {
//        Session session = sessionFactory.openSession();
//        List<SportOfficeWithSubSelect> sows = session.createQuery("select sows from SportOfficeWithSubSelect sows").getResultList();
//        return sows;
//    }
//
//    @Override
//    public List<SportOffice> getAllUser() {
//        Session session = sessionFactory.openSession();
//        List<SportOffice> sportOffices = session.createQuery("select s from SportOffice s").getResultList();
//        session.close();
//        return sportOffices;
//    }
//}
