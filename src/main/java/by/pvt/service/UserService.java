package by.pvt.service;

import by.pvt.entity.User;
import by.pvt.entity.testentity.PremiumUser;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void delete(Long id);
    List<User> findUserPremium();
    User findUser(Long id);
    List<User> getUsers();
}
