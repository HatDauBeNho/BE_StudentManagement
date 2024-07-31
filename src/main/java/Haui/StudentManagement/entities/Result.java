package Haui.StudentManagement.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="results")
@NoArgsConstructor
@AllArgsConstructor
public class Result extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="resultId")
    private int resultId;
    @Column(name = "courseRegistrationId")
    private int courseRegistrationId;
    @Column(name = "point")
    private double point;
}
