package Haui.StudentManagement.repository;

import Haui.StudentManagement.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
    @Query(value = "SELECT * FROM classrooms WHERE className = ?1 LIMIT 1", nativeQuery = true)
    Optional<Classroom> findByName(String name);
}
