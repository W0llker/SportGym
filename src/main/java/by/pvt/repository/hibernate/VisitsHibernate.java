package by.pvt.repository.hibernate;

import by.pvt.entity.Visits;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.pvt.repository.VisitsDao;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Repository
//@RequiredArgsConstructor
//public class VisitsHibernate implements VisitsDao {
//    private final SessionFactory sessionFactory;
//
//    @Override
//    public BigDecimal getAmountData(LocalDate start, LocalDate end) {
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery("select sum(c.amount) as sum from Visits c where c.dateVisits>:dateStart and c.dateVisits<:dateEnd");
//        query.setParameter("dateStart", start);
//        query.setParameter("dateEnd", end);
//        return (BigDecimal) query.getSingleResult();
//    }
//}
