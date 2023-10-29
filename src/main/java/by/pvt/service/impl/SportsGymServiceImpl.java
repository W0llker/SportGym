package by.pvt.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.pvt.repository.EmployeeDao;
import by.pvt.repository.VisitsDao;
import by.pvt.service.SportsGymService;

import java.math.BigDecimal;
import java.time.LocalDate;
@Service
@RequiredArgsConstructor
public class SportsGymServiceImpl implements SportsGymService {
    @Autowired
    private final VisitsDao visitsDao;
    @Autowired
    private final EmployeeDao employeeDao;

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
