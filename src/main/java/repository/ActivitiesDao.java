package repository;

import entity.Activities;

import java.util.List;

public interface ActivitiesDao {
    void add(Activities activities);
    void delete(Long id);
    Activities findById(Long id);
    Long getLowPrice();
    List<Activities> getAllUser();
}
