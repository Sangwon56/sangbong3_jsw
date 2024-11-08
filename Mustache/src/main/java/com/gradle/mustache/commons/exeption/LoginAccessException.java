package com.gradle.mustache.commons.exeption;

public class LoginAccessException extends RuntimeException {
    public LoginAccessException(String message) {
        super(message);
    }
}
