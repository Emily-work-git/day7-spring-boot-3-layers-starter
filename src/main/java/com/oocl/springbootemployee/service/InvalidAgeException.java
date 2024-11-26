package com.oocl.springbootemployee.service;

public class InvalidAgeException extends RuntimeException {
    public static final String INVALID_AGE_ERROR_MESSAGE = "Invalid employee age. Employee age should not be under 18 and over 65.";

    public InvalidAgeException() {
        super(INVALID_AGE_ERROR_MESSAGE);
    }
}