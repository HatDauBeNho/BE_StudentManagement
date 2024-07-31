package Haui.StudentManagement.controller;

import Haui.StudentManagement.custom.classroom.request.CreateClassroomRequest;
import Haui.StudentManagement.custom.data.reponse.CustomResponse;
import Haui.StudentManagement.custom.department.request.CreateDepartmentRequest;
import Haui.StudentManagement.entities.Department;
import Haui.StudentManagement.repository.DepartmentRepository;
import Haui.StudentManagement.repository.TeacherRepository;
import Haui.StudentManagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("createDepartment")
    public ResponseEntity<?> createDepartment(@RequestBody CreateDepartmentRequest request) {
        try {
            if (departmentService.findByName(request.getDepartmentName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Department already exists"));
            if (teacherRepository.findByName(request.getFullName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exists"));
            Department department = new Department();
            department.setDepartmentName(request.getDepartmentName());
            department.setTeacherId(teacherRepository.findByName(request.getFullName()).get().getTeacherId());
            department.setCreateAt(LocalDateTime.now());
            department.setUpdatedAt(LocalDateTime.now());
            departmentService.save(department);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create classroom"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllClassroom(){
        try
        {
            return ResponseEntity.ok(new CustomResponse<>(1, departmentService.findAllForView(), null));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}
