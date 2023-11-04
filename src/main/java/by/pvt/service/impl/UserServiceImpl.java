package by.pvt.service.impl;

import by.pvt.entity.Guest;
import by.pvt.entity.User;
import by.pvt.entity.testentity.PremiumUser;
import by.pvt.repository.UserDao;
import by.pvt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public User findUser(Long id) {
        return Optional.of(userDao.findById(id).orElseThrow(() -> new RuntimeException("Нету user с таким id " + id))).get();
    }

    @Override
    public List<User> findUserPremium() {
       return userDao.findPremium();
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getUsers() {
        return (List<User>) userDao.findAll();
    }
}
