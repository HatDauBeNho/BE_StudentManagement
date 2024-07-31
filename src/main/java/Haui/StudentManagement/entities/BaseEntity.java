package Haui.StudentManagement.entities;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


@MappedSuperclass
@Data
public class BaseEntity {

    @Column(name="createdAt")
    protected LocalDateTime createAt;

    @Column(name="updatedAt")
    protected LocalDateTime updatedAt;
}
