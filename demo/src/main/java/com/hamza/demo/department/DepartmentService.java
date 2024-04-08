package com.hamza.demo.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentService implements IDepartment {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentByID(String id) {
        System.out.println("test "+id);
        return departmentRepository.findById(id).orElseThrow();
    }
}
