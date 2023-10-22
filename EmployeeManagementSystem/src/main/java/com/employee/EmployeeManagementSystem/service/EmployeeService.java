package com.employee.EmployeeManagementSystem.service;

import com.employee.EmployeeManagementSystem.Entity.Employee;


import java.util.List;

public interface EmployeeService {


    Employee saveEmployee(Employee employee);

    Employee findEmployeeById(Long id);

    List<Employee> findAllEmployees();

    Employee updateEmployee(Long id, Employee updatedEmployee);

    Employee deleteEmployeeById(Long id);
}
