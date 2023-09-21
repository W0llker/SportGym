package repository;

import entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    void delete(Long id);
    User findById(Long id);
    List<User> getAllUser();
}
