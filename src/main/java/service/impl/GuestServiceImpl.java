package service.impl;

import entity.Guest;
import org.hibernate.Session;
import repository.GuestDao;
import service.GuestService;

import java.util.List;

public class GuestServiceImpl implements GuestService {
    private final GuestDao guestDao;

    public GuestServiceImpl(GuestDao guestDao) {
        this.guestDao = guestDao;
    }

    @Override
    public void add(Guest guest) {
        guestDao.add(guest);
    }

    @Override
    public void remove(Long id) {
        guestDao.remove(id);
    }

    @Override
    public Guest findById(Long id) {
        Guest guest = guestDao.findById(id);
        if(guest == null) {
            throw new RuntimeException();
        }
        return guest;
    }

    @Override
    public List<Guest> getAllGuest() {
        List<Guest> guestList = guestDao.getAllGuest();
        return guestList;
    }
}
