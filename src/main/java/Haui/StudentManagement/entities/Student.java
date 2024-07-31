package Haui.StudentManagement.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private int studentId;
    @Column(name = "accountId")
    private int accountId;
    @Column(name = "inforId")
    private int inforId;
    @Column(name = "classId")
    private int classId;
    @Column(name = "gpa")
    private double gpa;
}
