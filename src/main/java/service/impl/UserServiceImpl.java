package service.impl;

import entity.User;
import repository.UserDao;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.add(user);
    }

    @Override
    public User findUser(Long id) {
        return userDao.findById(id);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getAllUser();
    }
}
