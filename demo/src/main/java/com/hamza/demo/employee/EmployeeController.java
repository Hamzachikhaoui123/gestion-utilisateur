package com.hamza.demo.employee;

import com.hamza.demo.department.Department;
import com.hamza.demo.department.IDepartment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    @Autowired
     IEmployee iEmployee;
    @Autowired
     IDepartment iDepartment;
    @PostMapping(path = "/add")
    public Employee addEmployee( @RequestBody Employee employee,@RequestParam String id){
        Department department=iDepartment.getDepartmentByID(id);
        employee.setDepartment(department);
        return iEmployee.addEmployee(employee);
    };
    @GetMapping(path = "")
    public List<Employee> getAllEmployees(){
        return iEmployee.getEmployees();
    }
    @GetMapping(path = "{id}")
    public  Employee getEmployeeById(@PathVariable String id){
        return iEmployee.getEmployeeById(id);
    }
    @PutMapping(path = "/update/{idEmployee}")
    public Employee updateEmployee( @RequestBody Employee employee,@RequestParam String id,@PathVariable String idEmployee){
        System.out.println("idd "+ idEmployee);
        Department department=iDepartment.getDepartmentByID(id);
        employee.setDepartment(department);
        return iEmployee.updateEmployee(idEmployee,employee);
    };
}
