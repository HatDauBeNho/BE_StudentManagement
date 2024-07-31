package Haui.StudentManagement.service;

import Haui.StudentManagement.custom.classroom.response.ClassroomResponse;
import Haui.StudentManagement.entities.Classroom;
import java.util.List;
import java.util.Optional;

public interface ClassroomService extends Generate<Classroom> {
    Optional<Classroom> findByName(String name);
    List<ClassroomResponse> findAllForView();


}
