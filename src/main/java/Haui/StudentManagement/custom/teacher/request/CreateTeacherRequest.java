package Haui.StudentManagement.custom.teacher.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeacherRequest {
    private String fullName;
    private LocalDateTime dateOfBirth;
    private int gender;
    private String address;
    private String phoneNumber;
    private String email;
}
