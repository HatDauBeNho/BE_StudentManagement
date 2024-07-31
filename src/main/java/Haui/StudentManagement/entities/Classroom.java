package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="classRooms")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="classId")
    private int classId;
    @Column(name = "className")
    private String className;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "majorId")
    private int majorId;
    @Column(name ="teacherId")
    private int teacherId;

}
