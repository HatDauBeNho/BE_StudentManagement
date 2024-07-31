package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="infors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Infor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inforId")
    private int inforId;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "dateOfBirth")
    private LocalDateTime dateOfBirth;
    @Column(name = "gender")
    private int gender;

}
