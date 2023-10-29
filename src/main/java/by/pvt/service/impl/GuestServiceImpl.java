package by.pvt.service.impl;

import by.pvt.entity.Guest;
import by.pvt.repository.GuestDao;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.pvt.service.GuestService;

import java.util.List;
@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {
    @Autowired
    private final GuestDao guestDao;

    @Override
    public void add(Guest guest) {
        guestDao.save(guest);
    }

    @Override
    public void remove(Long id) {
        guestDao.deleteById(id);
    }

    @Override
    public Guest findById(Long id) {
        var guest = guestDao.findById(id);
        return guest.get();
    }

    @Override
    public List<Guest> getAllGuest() {
        return (List<Guest>) guestDao.findAll();
    }
}
