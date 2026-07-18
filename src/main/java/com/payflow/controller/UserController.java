package com.payflow.controller;

import com.payflow.entity.Users;
import com.payflow.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }


    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }


    @PutMapping
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}