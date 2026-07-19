package com.payflow.validator;

public final class ValidationConstants {

    private ValidationConstants() {}

    // Username
    public static final int USERNAME_MIN_LENGTH = 3;
    public static final int USERNAME_MAX_LENGTH = 20;
    public static final String USERNAME_REGEX = "^[a-zA-Z0-9_]+$";

    // Email
    public static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    // Password
    public static final int PASSWORD_MIN_LENGTH = 8;

    public static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$";
}