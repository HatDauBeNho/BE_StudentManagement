package Haui.StudentManagement.service.impl;

import Haui.StudentManagement.entities.CourseRegistration;
import Haui.StudentManagement.repository.CourseRegistrationRepository;
import Haui.StudentManagement.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Override
    public Optional<CourseRegistration> findByName(String name) {
        return courseRegistrationRepository.findByName(name);
    }

    @Override
    public List<CourseRegistration> findAll() {
        return courseRegistrationRepository.findAll();
    }

    @Override
    public Optional<CourseRegistration> findById(Integer id) {
        return courseRegistrationRepository.findById(id);
    }

    @Override
    public CourseRegistration save(CourseRegistration courseRegistration) {
        return courseRegistrationRepository.save(courseRegistration);
    }

    @Override
    public void deleteById(Integer id) {
        courseRegistrationRepository.deleteById(id);
    }
}
