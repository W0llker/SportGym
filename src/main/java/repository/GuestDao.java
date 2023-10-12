package repository;

import entity.Guest;

import java.util.List;

public interface GuestDao {
    void add(Guest guest);
    void remove(Long id);
    Guest findById(Long id);
    List<Guest> getAllGuest();
}
