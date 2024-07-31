package Haui.StudentManagement.custom.student.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentReponse {
    private String fullName;
    private LocalDateTime dateOfBirth;
    private int gender;
    private String address;
    private String phoneNumber;
    private String email;
    private double gpa;
    private String className;
}
