package com.hamza.demo.department;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

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
    @GetMapping(path = "/all")
    List<Department> departmentList (){
        return departmentService.getAllDepartment();
    }
}
