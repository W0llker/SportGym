package by.pvt.service;

import by.pvt.entity.Guest;

import java.util.List;

public interface GuestService {
    void add(Guest guest);
    void remove(Long id);
    Guest findById(Long id);
    List<Guest> getAllGuest();
}
