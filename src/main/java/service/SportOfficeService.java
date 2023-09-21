package service;

import entity.Activities;
import entity.SportOffice;

import java.util.List;
import java.util.Map;

public interface SportOfficeService {
    void add(SportOffice sportOffice);
    void delete(Long id);
    void editSportOffice (Long id,String param,String value);
    Double getPriceOnePerson(Long id);
    List<SportOffice> getAll();
    SportOffice findById(Long id);
}
