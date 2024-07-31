package Haui.StudentManagement.controller;

import Haui.StudentManagement.custom.data.reponse.CustomResponse;
import Haui.StudentManagement.custom.subject.request.CreateSubjectRequest;

import Haui.StudentManagement.entities.Subject;
import Haui.StudentManagement.service.DepartmentService;
import Haui.StudentManagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/createSubject")
    public ResponseEntity<?> createStudent(@RequestBody CreateSubjectRequest request) {
        try
        {
            if (subjectService.findByName(request.getSubjectName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Subject already exists"));
            if (departmentService.findByName(request.getDepartmentName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Department is not exists"));
            Subject subject=new Subject();
            subject.setSubjectName(request.getSubjectName());
            subject.setCredit(request.getCredit());
            subject.setDepartmentId(departmentService.findByName(request.getDepartmentName()).get().getDepartmentId());
            subject.setCreateAt(LocalDateTime.now());
            subject.setUpdatedAt(LocalDateTime.now());
            subjectService.save(subject);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create subject"));


        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAllSubject()
    {
        try
        {
            return ResponseEntity.ok(new CustomResponse<>(1, subjectService.findAllForView(), null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}
