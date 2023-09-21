package service;

import entity.Activities;

import java.util.List;

public interface ActivitiesService {
    void add(Activities activities);
    void delete(Long id);
    List<Activities> getAll();
    Activities findById(Long id);
}
