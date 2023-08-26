package com.example.employeemanagement.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Data
@NoArgsConstructor
@RestControllerAdvice
public class EmployeeException extends Exception{
    private String statusCode;
    private String message;
    private transient Object errorMessage;


    public EmployeeException(String errorCode,String message,String errorMessage)
    {
        this.statusCode=errorCode;
        this.message=message;
        this.errorMessage=errorMessage;
    }
    public EmployeeException(String errorCode,String message,String errorMessage,Throwable throwable)
    {
        super(message,throwable);
        this.statusCode=errorCode;
        this.errorMessage=errorMessage;
    }

    public EmployeeException(String errorCode,String message)
    {
        this.statusCode=errorCode;
        this.message=message;
        this.errorMessage=message;
    }

}
