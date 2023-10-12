package repository;

import entity.Visits;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface VisitsDao {
    void add(Visits visits);
    BigDecimal getAmountData(LocalDate start , LocalDate end);
}
