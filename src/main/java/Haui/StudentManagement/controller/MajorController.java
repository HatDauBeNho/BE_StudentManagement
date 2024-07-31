package Haui.StudentManagement.controller;

import Haui.StudentManagement.custom.data.reponse.CustomResponse;
import Haui.StudentManagement.custom.major.request.CreateMajorRequest;
import Haui.StudentManagement.entities.Major;
import Haui.StudentManagement.service.DepartmentService;
import Haui.StudentManagement.service.MajorService;
import Haui.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/major")
public class MajorController {
    @Autowired
    private MajorService majorService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TeacherService teacherService;

    @PostMapping("createMajor")
    public ResponseEntity<?> createMajor(@RequestBody CreateMajorRequest request) {
        try {
            if (majorService.findByName(request.getMajorName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major already exists"));
            if (departmentService.findByName(request.getDeparmentName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Department is not exists"));
            if (teacherService.findByName(request.getFullName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exists"));
            Major major=new Major();
            major.setMajorName(request.getMajorName());
            major.setDepartmentId(departmentService.findByName(request.getDeparmentName()).get().getDepartmentId());
            major.setTeacherId(teacherService.findByName(request.getFullName()).get().getTeacherId());
            major.setCreateAt(LocalDateTime.now());
            majorService.save(major);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create major"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllClassroom(){
        try
        {
            return ResponseEntity.ok(new CustomResponse<>(1, majorService.findAllForView(), null));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }


}
