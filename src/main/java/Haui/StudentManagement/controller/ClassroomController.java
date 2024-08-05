package Haui.StudentManagement.controller;

import Haui.StudentManagement.custom.classroom.request.CreateClassroomRequest;
import Haui.StudentManagement.custom.classroom.request.EditClassroomRequest;
import Haui.StudentManagement.custom.data.reponse.CustomResponse;
import Haui.StudentManagement.entities.Classroom;
import Haui.StudentManagement.service.ClassroomService;
import Haui.StudentManagement.service.MajorService;
import Haui.StudentManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/admin/createClassroom")
    public ResponseEntity<?> createClassroom(@RequestBody CreateClassroomRequest request) {
         try {

            if (classroomService.findByName(request.getClassName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Classroom already exists"));
            if (majorService.findByName(request.getMajorName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major is not exists"));
            if (teacherService.findByName(request.getFullName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exists"));
            Classroom classroom=new Classroom();
            classroom.setClassName(request.getClassName());
            classroom.setQuantity(request.getQuantity());
            classroom.setMajorId(majorService.findByName(request.getMajorName()).get().getMajorId());
            classroom.setTeacherId(teacherService.findByName(request.getFullName()).get().getTeacherId());
            classroom.setCreateAt(LocalDateTime.now());
            classroom.setUpdatedAt(LocalDateTime.now());
             classroomService.save(classroom);
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
            return ResponseEntity.ok(new CustomResponse<>(1, classroomService.findAllForView(), null));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PutMapping("/admin/editClassroom")
    public ResponseEntity<?> editClassroom (@RequestBody EditClassroomRequest editClassroomRequest)
    {
        try
        {

            if (classroomService.findById(editClassroomRequest.getClassId()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Class is not exits"));
            Classroom classroom=classroomService.findById(editClassroomRequest.getClassId()).get();
            if (editClassroomRequest.getClassName()!=null)
            {
                if (!editClassroomRequest.getClassName().equals(classroom.getClassName()))
                    classroom.setClassName(editClassroomRequest.getClassName());
            }

            if (editClassroomRequest.getMajorName()!=null)
            {
                if (majorService.findByName(editClassroomRequest.getMajorName()).isEmpty())
                    return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major is not exits"));
                if (!editClassroomRequest.getMajorName().equals(majorService.findById(classroom.getMajorId()).get().getMajorName())){
                    classroom.setMajorId(majorService.findByName(editClassroomRequest.getMajorName()).get().getMajorId());
                }
            }
            if (editClassroomRequest.getFullName()!=null)
            {
                if (teacherService.findByName(editClassroomRequest.getFullName()).isEmpty())
                    return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exits"));
                if (!editClassroomRequest.getFullName().equals(teacherService.getTeacherInfor(classroom.getTeacherId()).get().getFullName()))
                    classroom.setTeacherId(teacherService.findByName(editClassroomRequest.getFullName()).get().getTeacherId());
            }
            classroom.setUpdatedAt(LocalDateTime.now());
            classroomService.save(classroom);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Update success"));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @DeleteMapping("/admin/deleteClassroom/{classId}")
    public ResponseEntity<?> editClassroom(@PathVariable("classId") int classId)
    {
        try
        {
            if (classroomService.findById(classId).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Class is not exits"));
            classroomService.deleteById(classId);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "success delete"));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}
