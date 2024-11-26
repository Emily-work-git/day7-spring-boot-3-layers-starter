package com.oocl.springbootemployee.exception;

public class InvalidAgeWithSalaryException extends RuntimeException {
    public static final String INVALID_AGE_WITH_SALARY_MESSAGE = "Invalid employee age and salary. Employee age over 30 should not be waged under $20,000.";

    public InvalidAgeWithSalaryException() {
        super(INVALID_AGE_WITH_SALARY_MESSAGE);
    }
}
