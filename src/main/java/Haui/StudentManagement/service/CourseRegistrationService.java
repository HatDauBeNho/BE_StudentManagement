package Haui.StudentManagement.service;

import Haui.StudentManagement.entities.CourseRegistration;
import java.util.Optional;

public interface CourseRegistrationService extends Generate<CourseRegistration> {
    Optional<CourseRegistration> findByName(String name);

}
