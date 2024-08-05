package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="module_subjects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModuleSubject extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "moduleSubjectId")
    private int moduleSubjectId;
    @Column(name = "subjectId")
    private int subjectId;
    @Column(name = "currentStudent")
    private int currentStudent;
    @Column(name = "maximumStudent")
    private int maximumStudent;
    @Column(name = "teacherId")
    private int teacherId;
    @Column(name = "startAt")
    private LocalDate startAt;
    @Column(name = "endAt")
    private LocalDate endAt;
}
