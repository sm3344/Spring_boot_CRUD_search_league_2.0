package com.example.LolStudents.repository;
import com.example.LolStudents.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1% " +
            "OR s.role LIKE %?1% OR s.elo LIKE %?1%")

    public List<Student> search(String keyword);
}
