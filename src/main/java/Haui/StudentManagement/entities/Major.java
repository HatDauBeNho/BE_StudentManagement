package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="majors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Major extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="majorId")
    private int majorId;
    @Column(name = "majorName")
    private String majorName;
    @Column(name = "departmentId")
    private int departmentId;
    @Column(name = "teacherId")
    private int teacherId;
}
