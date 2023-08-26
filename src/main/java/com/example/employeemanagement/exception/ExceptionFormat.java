package com.example.employeemanagement.exception;

import lombok.Data;

@Data
public class ExceptionFormat {
    private String msg;
    private String status;
    private String error;
}
