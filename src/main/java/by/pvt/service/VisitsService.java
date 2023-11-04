package by.pvt.service;

import by.pvt.entity.Guest;
import by.pvt.entity.SportOffice;
import by.pvt.entity.Visits;

import java.util.List;


public interface VisitsService {
    void addVisits(Long idGuest, Long idSportOffice);

    void deleteVisits(Visits visits);

    void updateVisits(Visits visits);
    Visits findById(Long id);
    List<Visits> getAllVisits();
}
