package Haui.StudentManagement.service;

import Haui.StudentManagement.custom.student.request.CreateStudentRequest;
import Haui.StudentManagement.custom.student.response.StudentReponse;
import Haui.StudentManagement.entities.Infor;
import Haui.StudentManagement.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService  extends  Generate<Student>{
    Optional<Student> findByName(String name);
    Optional<Infor> getStudentInfor(int id);
    void createStudentAccount(CreateStudentRequest createStudentRequest);
    List<StudentReponse>  findAllForView();
}
