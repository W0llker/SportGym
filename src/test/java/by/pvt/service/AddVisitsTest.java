package by.pvt.service;

import by.pvt.dto.guest.Status;
import by.pvt.entity.Guest;
import by.pvt.entity.SportOffice;
import by.pvt.entity.Visits;
import by.pvt.service.impl.VisitsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddVisitsTest extends VisitsServiceTest {
    @Test
    public void addVisits_PositivTest() {
        Visits visits = new Visits();
        when(guestDao.findById(1l)).thenReturn(Optional.of(guest()));
        when(sportOfficeDao.findById(1l)).thenReturn(Optional.of(sportOffice()));
        when(visitsDao.countByGuest(guest())).thenReturn(5);
        when(guestDao.save(any())).thenReturn(guest());
        when(visitsDao.save(any())).thenReturn(visits);
        visitsService.addVisits(1l, 1l);
    }

    private Guest guest() {
        Guest guest = new Guest();
        guest.setId(1l);
        guest.setName("Никита");
        guest.setSurName("Bub");
        guest.setStatus(Status.PREMIUM);
        guest.setAmount(new BigDecimal(0));
        return guest;
    }

    private SportOffice sportOffice() {
        SportOffice sportOffice = new SportOffice();
        sportOffice.setId(1l);
        sportOffice.setName("Бассейн");
        sportOffice.setPriceInHour(new BigDecimal(250));
        return sportOffice;
    }
}
