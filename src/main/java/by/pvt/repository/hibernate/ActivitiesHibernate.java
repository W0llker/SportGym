package by.pvt.repository.hibernate;

import by.pvt.repository.ActivitiesDao;
import by.pvt.entity.Activities;
import by.pvt.entity.Employee;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
//@Repository
//@RequiredArgsConstructor
//public class ActivitiesHibernate implements ActivitiesDao {
//    private final SessionFactory sessionFactory;
//
//    @Override
//    public List<Activities> getAllUser() {
//        return null;
//    }
//
//    @Override
//    public Long getLowPrice() {
//        CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Long> activitiesCriteriaQuery = criteriaBuilder.createQuery(Long.class);
//        Root<Employee> activitiesRoot = activitiesCriteriaQuery.from(Employee.class);
//        activitiesCriteriaQuery.select(criteriaBuilder.min(activitiesRoot.get("cost")));
//
//        Session session = sessionFactory.openSession();
//        return session.createQuery(activitiesCriteriaQuery).getSingleResult();
//    }
//}
