package com.payflow.dao;

import com.payflow.entity.Users;
import com.payflow.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    private final UserRepository userRepository;

    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public void delete(Users user) {
        userRepository.delete(user);
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }
}