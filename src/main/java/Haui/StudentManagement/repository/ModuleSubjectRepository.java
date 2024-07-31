package Haui.StudentManagement.repository;

import Haui.StudentManagement.entities.ModuleSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleSubjectRepository extends JpaRepository<ModuleSubject,Integer> {
    @Query(value = "SELECT * FROM moduleSubjects WHERE moduleSubjectName = ?1 LIMIT 1", nativeQuery = true)
    Optional<ModuleSubject> findByName(String name);
}
