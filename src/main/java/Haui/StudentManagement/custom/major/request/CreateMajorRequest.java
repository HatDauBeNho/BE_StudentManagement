package Haui.StudentManagement.custom.major.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMajorRequest
{
    private String majorName;
    private String deparmentName;
    private String fullName;
}
