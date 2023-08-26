package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.EmployeeException;
import com.example.employeemanagement.service.EmpRepo;
import com.example.employeemanagement.service.EmpServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmpRepo empRepo;
    @Autowired
    EmpServiceImpl empService;

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Operation(summary = "Get a Employee by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the Employee", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",content = @Content),
            @ApiResponse(responseCode = "404", description = "Employee not found", content = @Content)})
    @PostMapping("/home/addEmp")
    ResponseEntity<Object> addEmp(@RequestBody Employee employee) throws EmployeeException {
        return new ResponseEntity<>(empService.saveEmp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/home/getAllEmp")
    ResponseEntity<Object> getAllEmp() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = empRepo.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/home/getEmpById/{empId}")
    ResponseEntity<Object> getEmpById(@PathVariable("empId") Long empId) throws EmployeeException {
        //return new ResponseEntity<>(empRepo.findById(empId),HttpStatus.OK);
        return new ResponseEntity<>(empService.getEmpById(empId), HttpStatus.OK);
    }

}
