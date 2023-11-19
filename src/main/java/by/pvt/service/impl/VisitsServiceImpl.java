package by.pvt.service.impl;

import by.pvt.entity.Guest;
import by.pvt.entity.Visits;
import by.pvt.dto.guest.Status;
import by.pvt.repository.GuestDao;
import by.pvt.repository.SportOfficeDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import by.pvt.repository.VisitsDao;
import by.pvt.service.VisitsService;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitsServiceImpl implements VisitsService {
    private final VisitsDao visitsDao;
    private final GuestDao guestDao;
    private final SportOfficeDao sportOfficeDao;

    // TODO: 23.10.2023
    @Override
    @Transactional
    public void addVisits(Long idGuest, Long idSportOffice) {
        Visits visits = new Visits();
        Guest guest = guestDao.findById(idGuest).orElseThrow(() -> new RuntimeException(""));
        visits.setGuest(guest);
        visits.setSportOffice(sportOfficeDao.findById(idSportOffice).orElseThrow(() -> new RuntimeException("")));
        visits.setAmount(BigDecimal.valueOf(guest.getStatus() == Status.ACTIVE ? 250 : 250 - 250/10));
        visits.setDateVisits(LocalDate.now());
        if(visitsDao.countByGuest(guest) > 10 && guest.getStatus() != Status.PREMIUM) {
            guest.setStatus(Status.PREMIUM);
        }
        guest.setAmount(guest.getAmount().add(visits.getAmount()));
        guestDao.save(guest);
        visitsDao.save(visits);
    }

    @Override
    @Transactional
    public void deleteVisits(Visits visits) {
        visitsDao.delete(visits);
    }

    @Override
    @Transactional
    public void updateVisits(Visits visits) {
        visitsDao.save(visits);
    }

    @Override
    public Visits findById(Long id) {
        var visits = Optional.of(visitsDao.findById(id).orElseThrow(() -> new RuntimeException("")));
        return visits.get();
    }

    @Override
    public List<Visits> getAllVisits() {
        return visitsDao.findAll();
    }
}
