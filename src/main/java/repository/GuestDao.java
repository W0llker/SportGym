package repository;

import entity.Guest;

import java.util.List;

public interface GuestDao {
    void add(Guest guest);
    List<Guest> findByName(String name);
    void remove(Long id);
    Guest findById(Long id);
    List<Guest> getAllGuest();
}
