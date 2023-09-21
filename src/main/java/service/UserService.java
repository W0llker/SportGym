package service;

import entity.User;
import entity.testentity.PremiumUser;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void delete(Long id);
    List<PremiumUser> findUserPremium();
    User findUser(Long id);
    List<User> getUsers();
}
