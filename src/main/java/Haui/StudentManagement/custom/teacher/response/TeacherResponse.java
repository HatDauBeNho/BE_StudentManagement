package Haui.StudentManagement.custom.teacher.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse {
    private int teacherId;
    private String fullName;
    private LocalDateTime dateOfBirth;
    private int gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String roleName;

}
