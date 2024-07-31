package Haui.StudentManagement.service;

import Haui.StudentManagement.custom.major.response.MajorResponse;
import Haui.StudentManagement.entities.Classroom;
import Haui.StudentManagement.entities.Major;
import Haui.StudentManagement.repository.MajorRepository;

import java.util.List;
import java.util.Optional;

public interface MajorService extends  Generate<Major>{
    Optional<Major> findByName(String name);
    List<MajorResponse> findAllForView();
}
