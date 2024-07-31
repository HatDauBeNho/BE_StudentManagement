package Haui.StudentManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roleId")
    private int roleId;
    @Column(name = "roleName")
    private String roleName;
}
