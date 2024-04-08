package com.hamza.demo.department;

import java.util.List;

public interface IDepartment {
    Department addDepartment(Department department);
    List<Department> getAllDepartment();
    Department  getDepartmentByID(String id);
}
