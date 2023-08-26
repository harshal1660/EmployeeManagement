package com.example.employeemanagement.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int addId;
    String line1;
    String country;
    String state;
}
