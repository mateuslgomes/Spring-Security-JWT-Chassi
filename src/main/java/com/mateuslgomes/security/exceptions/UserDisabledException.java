package com.mateuslgomes.security.exceptions;

public class UserDisabledException extends RuntimeException {

    public UserDisabledException(String message) {
        super(message);
    }

}
