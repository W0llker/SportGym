package by.pvt.service;

import by.pvt.entity.testentity.SportOfficeWithSubSelect;
import by.pvt.entity.SportOffice;

import java.util.List;

public interface SportOfficeService {
    void add(SportOffice sportOffice);

    void delete(Long id);

    void editSportOffice(Long id, String param, String value);

    List<SportOffice> findSmallPremises();

    Double getPriceOnePerson(Long id);

    List<SportOffice> getAll();

    SportOffice findById(Long id);
}
