package Haui.StudentManagement.entities;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private int accountId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "roleId")
    private int roleId;

}
