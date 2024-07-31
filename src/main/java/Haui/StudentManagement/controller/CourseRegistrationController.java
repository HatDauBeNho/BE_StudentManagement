package Haui.StudentManagement.controller;

import Haui.StudentManagement.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courseRegistration")
public class CourseRegistrationController {
    @Autowired
    private CourseRegistrationService courseRegistrationService;


}
