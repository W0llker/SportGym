package by.pvt.repository;

import by.pvt.entity.Save;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaveDao extends JpaRepository<Save,Long> {
    List<Save> findByStartDate(LocalDate startDate);
    @Query("select s from Save s order by s.id")
    Page<Save> findAll(Pageable pageable);
}
