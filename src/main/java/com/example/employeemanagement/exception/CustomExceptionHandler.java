package com.example.employeemanagement.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

@ExceptionHandler(EmployeeException.class)
    ResponseEntity<Object> AlreadyExistsException(EmployeeException exception)
    {
        ExceptionFormat exceptionFormat = new ExceptionFormat();
        exceptionFormat.setStatus(exception.getStatusCode());
        exceptionFormat.setMsg(exception.getMessage());
        exceptionFormat.setError((String) exception.getErrorMessage());
        return new ResponseEntity<>(exceptionFormat, HttpStatusCode.valueOf(Integer.parseInt(exception.getStatusCode())));
    }
}
