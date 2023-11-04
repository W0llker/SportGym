package by.pvt.repository;

import by.pvt.entity.Guest;
import by.pvt.entity.Visits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface VisitsDao extends JpaRepository<Visits,Long> {
    @Query("select sum(c.amount) as sum from Visits c where c.dateVisits>:start and c.dateVisits<:end")
    BigDecimal getAmountData(LocalDate start , LocalDate end);
    Integer countByGuest(Guest guest);
}
