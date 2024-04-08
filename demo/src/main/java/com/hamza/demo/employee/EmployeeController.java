package com.hamza.demo.employee;

import com.hamza.demo.department.Department;
import com.hamza.demo.department.IDepartment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("id  "+id);
        Department department=iDepartment.getDepartmentByID(id);
        employee.setDepartment(department);
        System.out.println("de  " + department);

        return iEmployee.addEmployee(employee);
    };
}
