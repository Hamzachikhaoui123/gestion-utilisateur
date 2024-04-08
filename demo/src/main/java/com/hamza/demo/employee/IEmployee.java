package com.hamza.demo.employee;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployee {
    Employee addEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee getEmployeeById(String id);
    Employee updateEmployee(String id , Employee employee);
    ResponseEntity DeleteEmployee(String id);
}
