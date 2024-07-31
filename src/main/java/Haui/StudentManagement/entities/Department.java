package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "departments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    private int departmentId;
    @Column(name = "departmentName")
    private String departmentName;
    @Column(name = "teacherId")
    private int teacherId;

}
