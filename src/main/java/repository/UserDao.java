package repository;

import entity.User;
import entity.testentity.PremiumUser;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(Long id);
    List<PremiumUser> findPremium();
    User findById(Long id);
    List<User> getAllUser();
}
