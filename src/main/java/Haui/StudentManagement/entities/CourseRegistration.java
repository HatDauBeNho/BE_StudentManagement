package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "course_registrations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistration extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseRegistrationId")
    private int courseRegistrationId;
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "moduleSubjectId")
    private int moduleSubjectId;

}
