package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int empId;
    String empName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_add_id")
    Address empAdd;
}
