package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="subjects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject  extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjectId")
    private int subjectId;
    @Column(name = "subjectName")
    private String subjectName;
    @Column(name = "credit")
    private int credit;
    @Column(name = "departmentId")
    private int departmentId;

}
