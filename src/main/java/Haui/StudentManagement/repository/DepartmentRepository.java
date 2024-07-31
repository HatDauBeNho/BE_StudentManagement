package Haui.StudentManagement.repository;

import Haui.StudentManagement.entities.Classroom;
import Haui.StudentManagement.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    @Query(value = "SELECT * FROM departments WHERE departmentName = ?1 LIMIT 1", nativeQuery = true)
    Optional<Department> findByName(String name);
}
