package com.example.CrudRapido.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_employee")
public class Employee {
    @Id
    private Long dni;

    private String firstName;

    private String lastName;

    @Column(name = "email_adress", unique = true)
    private String email;

    private String cargo;

    private int edad;

    private double salary;

    private String company;

    private Long telefono;
}
