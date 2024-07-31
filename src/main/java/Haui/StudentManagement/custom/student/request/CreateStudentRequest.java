package Haui.StudentManagement.custom.student.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {
    @Pattern(regexp = "^[a-zA-Z ]{5,50}$")
    private String fullName;

    private LocalDateTime dateOfBirth;
    private int gender;
    private String address;
    private String phoneNumber;

    @Pattern(regexp = ".*@gmail\\.com$")
    private String email;

    private String className;
}
