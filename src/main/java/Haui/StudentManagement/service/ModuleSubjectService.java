package Haui.StudentManagement.service;

import Haui.StudentManagement.entities.ModuleSubject;
import java.util.Optional;

public interface ModuleSubjectService extends Generate<ModuleSubject> {
    Optional<ModuleSubject> findByName(String name);
}
