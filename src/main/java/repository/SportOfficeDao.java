package repository;


import entity.SportOffice;
import entity.testentity.SportOfficeWithSubSelect;

import java.util.List;

public interface SportOfficeDao {
    void add(SportOffice sportOffice);

    void delete(Long id);
    void getAllOfficesAndAllActivitiesAndOfficesById(Long id);

    void edit(Long id, String param, String name);

    SportOffice findById(Long id);

    List<SportOfficeWithSubSelect> findSmallPremises();

    List<SportOffice> getAllUser();
}
