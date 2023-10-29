package by.pvt.service;

import by.pvt.dto.activities.ActivitiesRequest;
import by.pvt.dto.activities.ActivitiesResponse;
import by.pvt.entity.Activities;

import java.util.List;

public interface ActivitiesService {
    ActivitiesResponse add(ActivitiesRequest activities);
    void delete(Long id);
    List<ActivitiesResponse> getAll();
    ActivitiesResponse findById(Long id);
}
