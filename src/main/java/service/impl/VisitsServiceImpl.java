package service.impl;

import entity.Visits;
import repository.VisitsDao;
import service.VisitsService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VisitsServiceImpl implements VisitsService {
    private final VisitsDao visitsDao;

    public VisitsServiceImpl(VisitsDao visitsDao) {
        this.visitsDao = visitsDao;
    }

    @Override
    public void addVisits(Long idUser, Long idSportOffice) {
        visitsDao.add(new Visits(idUser, LocalDate.now(),new BigDecimal(500),idSportOffice));
    }
}
