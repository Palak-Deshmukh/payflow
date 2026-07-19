package com.payflow.validator;

import com.payflow.dao.AuthDao;
import com.payflow.dto.request.UserRequest;

import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class AuthValidator {

    private final AuthDao authDao;

    public AuthValidator(AuthDao authDao) {
        this.authDao = authDao;
    }

    public void validateSignup(UserRequest request) {

        validateUsername(request.getName());
        validateEmail(request.getEmail());
        validatePassword(request.getPassword());

        checkNameExists(request.getName());
        checkEmailExists(request.getEmail());
    }

    private void validateUsername(String username) {

        if (username == null || username.isBlank()) {
            throw new RuntimeException("Username is required");
        }

        if (username.length() < ValidationConstants.USERNAME_MIN_LENGTH ||
                username.length() > ValidationConstants.USERNAME_MAX_LENGTH) {
            throw new RuntimeException(
                    "Username must be between 3 and 20 characters");
        }

        if (!Pattern.matches(
                ValidationConstants.USERNAME_REGEX,
                username)) {

            throw new RuntimeException(
                    "Username can contain only letters, numbers and underscore");
        }
    }

    private void validateEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new RuntimeException("Email is required");
        }

        if (!Pattern.matches(
                ValidationConstants.EMAIL_REGEX,
                email)) {

            throw new RuntimeException("Invalid email address");
        }
    }

    private void validatePassword(String password) {

        if (password == null || password.isBlank()) {
            throw new RuntimeException("Password is required");
        }

        if (!Pattern.matches(
                ValidationConstants.PASSWORD_REGEX,
                password)) {

            throw new RuntimeException(
                    "Password must contain at least 8 characters, one uppercase letter, one lowercase letter, one digit and one special character");
        }
    }

    private void checkNameExists(String name) {

        if (authDao.existsByName(name)) {
            throw new RuntimeException("Name already exists");
        }
    }

    private void checkEmailExists(String email) {

        if (authDao.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }
    }
}