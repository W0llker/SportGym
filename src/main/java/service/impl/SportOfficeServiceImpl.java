package service.impl;

import entity.SportOffice;
import repository.SportOfficeDao;
import repository.UserDao;
import service.SportOfficeService;

import java.util.List;

public class SportOfficeServiceImpl implements SportOfficeService {
    private final SportOfficeDao sportOfficeDao;

    public SportOfficeServiceImpl(SportOfficeDao sportOfficeDao) {
        this.sportOfficeDao = sportOfficeDao;
    }

    @Override
    public void add(SportOffice sportOffice) {
        sportOfficeDao.add(sportOffice);
    }

    @Override
    public void editSportOffice(Long id,String param,String value) {
        sportOfficeDao.edit(id,param,value);
    }

    @Override
    public void delete(Long id) {
        sportOfficeDao.delete(id);
    }

    @Override
    public Double getPriceOnePerson(Long id) {
        SportOffice sportOffice = sportOfficeDao.findById(id);
        return (sportOffice.getPriceInHour().doubleValue() / sportOffice.getMaxPeople());
    }

    @Override
    public List<SportOffice> getAll() {
        return sportOfficeDao.getAllUser();
    }

    @Override
    public SportOffice findById(Long id) {
        return sportOfficeDao.findById(id);
    }
}
