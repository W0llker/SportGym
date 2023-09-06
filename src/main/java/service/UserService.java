package service;

import entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void delete(Long id);
    User findUser(Long id);
    List<User> getUsers();
}
