package Haui.StudentManagement.controller;

import Haui.StudentManagement.custom.data.reponse.CustomResponse;
import Haui.StudentManagement.custom.student.request.CreateStudentRequest;
import Haui.StudentManagement.service.AccountService;
import Haui.StudentManagement.service.ClassroomService;
import Haui.StudentManagement.service.InforService;
import Haui.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private InforService inforService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/createStudent")
    public ResponseEntity<?> createStudent(@RequestBody CreateStudentRequest request, Errors errors) {
        try {
            if (studentService.findByName(request.getFullName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Student already exists"));
            if (classroomService.findByName(request.getClassName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Class is not exists"));
            if (errors.hasErrors()) {
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Incorrect input format"));
            }
            studentService.createStudentAccount(request);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create student"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllStudent(){
        try
        {
            return ResponseEntity.ok(new CustomResponse<>(1, studentService.findAllForView(), null));
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

}
