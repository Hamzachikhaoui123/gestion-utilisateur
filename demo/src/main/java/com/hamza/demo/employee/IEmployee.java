package com.hamza.demo.employee;

import java.util.List;

public interface IEmployee {
    Employee addEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee getEmployeeById(String id);
}
