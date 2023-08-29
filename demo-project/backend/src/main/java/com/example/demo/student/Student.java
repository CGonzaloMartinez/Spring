package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Student {
    @Id 
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Integer id;
    private String name;
    private LocalDate dob;
    private String email;
    private String photo;
    private String city;
    
    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" + 
                "id=" + id +
                "name='" + name + '\'' +
                "dob=" + dob +
                "age=" + getAge() + 
                "email='" + email + '\'' +
                "city='" + city  + '\'' + 
                "photo='" + photo + '\'' + 
                '}';
    }
}
