package service.impl;

import repository.EmployeeDao;
import repository.VisitsDao;
import repository.hibernate.EmployeeHibernate;
import repository.hibernate.VisitsHibernate;
import service.SportsGymService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SportsGymServiceImpl implements SportsGymService {
    private final VisitsDao visitsDao;
    private final EmployeeDao employeeDao;

    public SportsGymServiceImpl() {
        visitsDao = new VisitsHibernate();
        employeeDao = new EmployeeHibernate();
    }

    @Override
    public BigDecimal getRevenue(LocalDate start, LocalDate end) {
        return visitsDao.getAmountData(start, end);
    }

    @Override
    public BigDecimal getIncome(LocalDate start, LocalDate end) {
        return new BigDecimal(getRevenue(start, end).doubleValue() - getExpenses(start, end).doubleValue());
    }

    @Override
    public BigDecimal getExpenses(LocalDate start, LocalDate end) {
        BigDecimal bigDecimal = employeeDao.getExpenses();
        System.out.println(bigDecimal);
        long countDays = end.toEpochDay() - start.toEpochDay();
        System.out.println(countDays);
        return new BigDecimal((bigDecimal.intValue() / 30) * countDays);
    }
}
