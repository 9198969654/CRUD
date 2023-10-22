package com.employee.EmployeeManagementSystem.service.impl;

import com.employee.EmployeeManagementSystem.Entity.Employee;
import com.employee.EmployeeManagementSystem.exception.EmployeeNotFoundException;
import com.employee.EmployeeManagementSystem.repository.EmployeeRepository;
import com.employee.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

//    private ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Find the existing employee by ID
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }

        // Update the fields of the existing employee with the values from updatedEmployee
        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastName(updatedEmployee.getLastName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        // You can update other fields as needed

        // Save the updated employee
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public Employee deleteEmployeeById(Long id) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }

        employeeRepository.delete(existingEmployee);

        return existingEmployee;
    }





}

