package com.example.manage.exception;

public class PasswordIncorrectException extends  RuntimeException{
    public PasswordIncorrectException(String message) {
        super(message);
    }
}
