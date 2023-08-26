package com.example.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>{
    
    @Query("SELECT s FROM Student s WHERE s.id = ?1 or s.email = ?2")
    Optional<Student> findStudentByIdOrEmail(Integer id, String email);
}
