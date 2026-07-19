package com.payflow.dao;

import com.payflow.entity.Users;
import com.payflow.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AuthDao {

    private final UserRepository userRepository;

    public AuthDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public boolean existsByName(String name) {
        return userRepository.existsByName(name);
    }

    public Optional<Users> findByName(String name) {
        return userRepository.findByName(name);
    }

    public Optional<Users> findByEmailOrName(String value) {
        return userRepository.findByEmailOrName(value, value);
    }

    public Optional<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}