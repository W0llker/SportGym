package service;

import entity.Guest;

import java.util.List;

public interface GuestService {
    void add(Guest guest);
    void remove(Long id);
    Guest findById(Long id);
    List<Guest> getAllGuest();
}
