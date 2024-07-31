package Haui.StudentManagement.service;

import Haui.StudentManagement.custom.subject.response.SubjectResponse;
import Haui.StudentManagement.entities.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService extends Generate<Subject>{
    Optional<Subject> findByName(String name);
    List<SubjectResponse> findAllForView();
}
