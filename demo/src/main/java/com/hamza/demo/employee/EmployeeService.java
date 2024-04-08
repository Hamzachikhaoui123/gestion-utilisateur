package com.hamza.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployee {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        Employee employeeUpdate=getEmployeeById(id);
        employeeUpdate.setLastName(employee.getLastName());
        employeeUpdate.setBirthdate(employee.getBirthdate());
        employeeUpdate.setFirstName(employee.getFirstName());
        employeeUpdate.setEmail(employee.getEmail());
        employeeUpdate.setRole(employee.getRole());
        employeeUpdate.setDepartment(employee.getDepartment());

        return employeeRepository.save(employeeUpdate);
    }

    @Override
    public ResponseEntity<String> DeleteEmployee(String id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Employee deleted avec success");

    }
}
