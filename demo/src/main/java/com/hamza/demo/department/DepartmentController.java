package com.hamza.demo.department;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")

public class DepartmentController {
    @Autowired
    private  final  DepartmentService departmentService;
    @PostMapping(path = "/add")
    Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping(path = "{id}")
    Department getDepartmentById(@PathVariable String id){
        return departmentService.getDepartmentByID(id);
    }
}
