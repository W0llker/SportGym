package by.pvt.repository;


import by.pvt.entity.testentity.SportOfficeWithSubSelect;
import by.pvt.entity.SportOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SportOfficeDao extends JpaRepository<SportOffice,Long> {

    void getAllOfficesAndAllActivitiesAndOfficesById(Long id);
    @Query("select so from SportOffice so where so.maxPeople <= 15")
    List<SportOffice> findSmallPremises();

}
