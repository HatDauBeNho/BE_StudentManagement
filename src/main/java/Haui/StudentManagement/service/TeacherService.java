package Haui.StudentManagement.service;

import Haui.StudentManagement.custom.student.request.CreateStudentRequest;
import Haui.StudentManagement.custom.student.response.StudentReponse;
import Haui.StudentManagement.custom.teacher.request.CreateTeacherRequest;
import Haui.StudentManagement.custom.teacher.response.TeacherResponse;
import Haui.StudentManagement.entities.Infor;
import Haui.StudentManagement.entities.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService extends Generate<Teacher> {
    Optional<Teacher> findByName(String name);
    Optional<Infor> getTeacherInfor(int id);
    void createTeacherAccount(CreateTeacherRequest request);
    List<TeacherResponse> findAllForView();

}
