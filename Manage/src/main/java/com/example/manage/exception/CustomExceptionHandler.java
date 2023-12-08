package com.example.manage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({NotFoundException.class, AccountExistsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  ErrorResponse handleNotFoundException()  {
        return  new ErrorResponse(HttpStatus.NOT_FOUND, "NOT FOUND");
    }

}
