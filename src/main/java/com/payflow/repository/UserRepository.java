package com.payflow.repository;

import com.payflow.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByName(String name);

    boolean existsByName(String name);

    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Users> findByEmailOrName(String email, String name);
}