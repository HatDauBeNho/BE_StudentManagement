package Haui.StudentManagement.repository;

import Haui.StudentManagement.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Integer> {
    @Query(value = "SELECT * FROM subjects WHERE  subjectName= ?1 LIMIT 1", nativeQuery = true)
    Optional<Subject> findByName(String name);

}
