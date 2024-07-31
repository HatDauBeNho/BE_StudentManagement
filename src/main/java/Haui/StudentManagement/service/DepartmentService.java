package Haui.StudentManagement.service;

import Haui.StudentManagement.custom.department.response.DepartmentResponse;
import Haui.StudentManagement.entities.Classroom;
import Haui.StudentManagement.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService extends Generate<Department> {
    Optional<Department> findByName(String name);
    List<DepartmentResponse> findAllForView();

}
