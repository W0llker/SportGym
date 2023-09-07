package repository;

import entity.Activities;
import entity.SportOffice;

import java.util.List;

public interface SportOfficeDao {
    void add(SportOffice sportOffice);

    void delete(Long id);

    void edit(Long id, String param, String name);

    SportOffice findById(Long id);

    List<SportOffice> getAllUser();
}
