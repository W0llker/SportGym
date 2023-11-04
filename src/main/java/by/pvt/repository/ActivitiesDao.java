package by.pvt.repository;

import by.pvt.entity.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActivitiesDao extends JpaRepository<Activities,Long> {
    @Query("select min(a.cost) from Activities a ")
    Long getLowPrice();
}
