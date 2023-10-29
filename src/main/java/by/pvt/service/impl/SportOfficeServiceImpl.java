package by.pvt.service.impl;

import by.pvt.entity.SportOffice;
import by.pvt.entity.testentity.SportOfficeWithSubSelect;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.pvt.repository.SportOfficeDao;
import by.pvt.service.SportOfficeService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SportOfficeServiceImpl implements SportOfficeService {
    @Autowired
    private final SportOfficeDao sportOfficeDao;

    @Override
    @Transactional
    public void add(SportOffice sportOffice) {
        sportOfficeDao.save(sportOffice);
    }

    @Override
    @Transactional
    public void editSportOffice(Long id, String param, String value) {
//        sportOfficeDao.edit(id, param, value);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        sportOfficeDao.deleteById(id);
    }

    @Override
    public List<SportOffice> findSmallPremises() {
        return sportOfficeDao.findSmallPremises();
    }

    @Override
    public Double getPriceOnePerson(Long id) {
        var sportOffice = Optional.of(sportOfficeDao.findById(id).orElseThrow(() -> new RuntimeException("Нету такого зала с таким id " + id))).get();
        return (sportOffice.getPriceInHour().doubleValue() / sportOffice.getMaxPeople());
    }

    @Override
    public List<SportOffice> getAll() {
        return (List<SportOffice>) sportOfficeDao.findAll();
    }

    @Override
    public SportOffice findById(Long id) {
        var sport = Optional.of(sportOfficeDao.findById(id).orElseThrow(() -> new RuntimeException("Нету такого зала с таким id " + id)));
        return sport.get();
    }
}
