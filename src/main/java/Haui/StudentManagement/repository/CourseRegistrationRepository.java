package Haui.StudentManagement.repository;

import Haui.StudentManagement.entities.CourseRegistration;
import Haui.StudentManagement.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration,Integer> {
    @Query(value = "SELECT * FROM course_registrations WHERE courseRegistrationName = ?1 LIMIT 1", nativeQuery = true)
    Optional<CourseRegistration> findByName(String name);
}
