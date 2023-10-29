package by.pvt.repository;

import by.pvt.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestDao extends JpaRepository<Guest,Long> {
    List<Guest> findByName(String name);
}
