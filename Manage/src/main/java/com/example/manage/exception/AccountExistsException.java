package com.example.manage.exception;

public class AccountExistsException extends RuntimeException{
    public AccountExistsException(String message) {
        super(message);
    }
}
