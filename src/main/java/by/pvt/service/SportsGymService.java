package by.pvt.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface SportsGymService {
    BigDecimal getRevenue(LocalDate start, LocalDate end);
    BigDecimal getIncome(LocalDate start, LocalDate end);
    BigDecimal getExpenses(LocalDate start, LocalDate end);
}
