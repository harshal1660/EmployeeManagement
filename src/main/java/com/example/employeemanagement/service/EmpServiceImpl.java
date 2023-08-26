package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl {

    @Autowired
    EmpRepo empRepo;


    public Object saveEmp(Employee employee) throws EmployeeException {

        if (empRepo.existsById((long) employee.getEmpId())) {
            throw new EmployeeException("403", "FAILURE", "Employee already exists");
        } else {
            empRepo.save(employee);
        }
        return empRepo.findById((long) employee.getEmpId());
    }

    public Object getEmpById(Long empId) throws EmployeeException {
        Object employee=new Object();
        if(empRepo.existsById(empId)){
           employee= empRepo.findById(empId);
        }else {
            throw new EmployeeException("404","FAILURE","Employee not found");
        }
        return employee;
    }


}
