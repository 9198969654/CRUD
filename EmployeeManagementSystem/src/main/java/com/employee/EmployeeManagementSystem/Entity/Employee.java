package com.employee.EmployeeManagementSystem.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    // Constructors (default and parameterized)

    // Getters and Setters for all fields

    // Other methods as needed

    // You can also specify the table name if needed:
    // @Table(name = "employee")

    // Additional business logic, relationships, etc.
}
