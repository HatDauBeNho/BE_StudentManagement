package Haui.StudentManagement.custom.classroom.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomResponse {
    private int classId;
    private String className;
    private int quantity;
    private String majorName;
    private String departmentName;
    private String fullName;
    private String phoneNumber;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;


}
