package Haui.StudentManagement.controller;

import Haui.StudentManagement.custom.classroom.request.CreateClassroomRequest;
import Haui.StudentManagement.custom.classroom.request.EditClassroomRequest;
import Haui.StudentManagement.custom.data.reponse.CustomResponse;
import Haui.StudentManagement.custom.department.request.CreateDepartmentRequest;
import Haui.StudentManagement.custom.department.request.EditDepartmentRequest;
import Haui.StudentManagement.entities.Department;
import Haui.StudentManagement.repository.DepartmentRepository;
import Haui.StudentManagement.repository.TeacherRepository;
import Haui.StudentManagement.service.DepartmentService;
import Haui.StudentManagement.service.TeacherService;
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
    private TeacherService teacherService;

    @PostMapping("/admin/createDepartment")
    public ResponseEntity<?> createDepartment(@RequestBody CreateDepartmentRequest request) {
        try {
            if (departmentService.findByName(request.getDepartmentName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Department already exists"));
            if (teacherService.findByName(request.getFullName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exists"));
            Department department = new Department();
            department.setDepartmentName(request.getDepartmentName());
            department.setTeacherId(teacherService.findByName(request.getFullName()).get().getTeacherId());
            department.setCreateAt(LocalDateTime.now());
            department.setUpdatedAt(LocalDateTime.now());
            departmentService.save(department);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create classroom"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
    @GetMapping("/admin/getAll")
    public ResponseEntity<?> getAllClassroom(){
        try
        {
            return ResponseEntity.ok(new CustomResponse<>(1, departmentService.findAllForView(), null));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PutMapping("/admin/editDepartment")
    public ResponseEntity<?> editDepartment (@RequestBody EditDepartmentRequest request)
    {
        try
        {
            if (departmentService.findById(request.getDepartmentId()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Department is not exits"));
            Department department=departmentService.findById(request.getDepartmentId()).get();
            if (request.getDepartmentName()!=null)
            {
                if (!request.getDepartmentName().equals(department.getDepartmentName()))
                        department.setDepartmentName(request.getDepartmentName());
            }
            if (request.getTeacherName()!=null)
            {
                if (departmentService.findByName(request.getDepartmentName()).isEmpty())
                    return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exits"));
                if (!request.getTeacherName().equals(teacherService.getTeacherInfor(department.getTeacherId()).get().getFullName()))
                    department.setTeacherId(teacherService.findByName(request.getTeacherName()).get().getTeacherId());
            }
            department.setUpdatedAt(LocalDateTime.now());
            departmentService.save(department);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Update success"));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
    @DeleteMapping("/admin/deleteDepartment/{departmentId}")
    public ResponseEntity<?> editDepartment(@PathVariable("departmentId") int departmentId)
    {
        try
        {
            if (departmentService.findById(departmentId).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Department is not exits"));
            departmentService.deleteById(departmentId);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success delete"));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}
