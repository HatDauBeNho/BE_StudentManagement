package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="teachers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherId")
    private int teacherId;
    @Column(name = "accountId")
    private int accountId;
    @Column(name = "inforId")
    private int inforId;
}
