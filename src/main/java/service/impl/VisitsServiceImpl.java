package service.impl;

import entity.Guest;
import entity.SportOffice;
import entity.Visits;
import repository.VisitsDao;
import service.VisitsService;

import java.time.LocalDate;

public class VisitsServiceImpl implements VisitsService {
    private final VisitsDao visitsDao;

    public VisitsServiceImpl(VisitsDao visitsDao) {
        this.visitsDao = visitsDao;
    }

    @Override
    public void addVisits(Guest guest, SportOffice sportOffice) {
        Visits visits = new Visits();
        visits.setGuest(guest);
        visits.setSportOffice(sportOffice);
        visits.setDateVisits(LocalDate.now());
        visitsDao.add(visits);
    }
}
