package by.pvt.repository;

import by.pvt.entity.User;
import by.pvt.entity.testentity.PremiumUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> {
    @Query("select g from Guest g where g.status = 'PREMIUM'")
    List<User> findPremium();
}
