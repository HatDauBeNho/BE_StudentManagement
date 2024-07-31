package Haui.StudentManagement.repository;

import Haui.StudentManagement.entities.Department;
import Haui.StudentManagement.entities.Infor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InforRepository extends JpaRepository<Infor,Integer> {
    @Query(value = "SELECT * FROM infors WHERE fullName = ?1 LIMIT 1", nativeQuery = true)
    Optional<Infor> findByName(String name);
}
