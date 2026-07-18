package com.payflow.service;

import com.payflow.dao.UserDao;
import com.payflow.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Users createUser(Users user) {
        return userDao.save(user);
    }

    public Users getUserById(Long id) {
        return userDao.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Users> getAllUsers() {
        return userDao.findAll();
    }

    public Users updateUser(Users user) {
        return userDao.save(user);
    }

    public void deleteUser(Long id) {

        Users user = getUserById(id);
        userDao.delete(user);
    }
}