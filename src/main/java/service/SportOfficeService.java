package service;

import entity.SportOffice;
import entity.testentity.SportOfficeWithSubSelect;

import java.util.List;

public interface SportOfficeService {
    void add(SportOffice sportOffice);

    void delete(Long id);

    void editSportOffice(Long id, String param, String value);

    List<SportOfficeWithSubSelect> findSmallPremises();

    Double getPriceOnePerson(Long id);

    List<SportOffice> getAll();

    SportOffice findById(Long id);
}
