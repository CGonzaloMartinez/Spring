package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;

@Entity
@Table
public class Student {
    @Id @Getter private Integer id;
    @Getter private String name;
    @Getter  LocalDate dob;
    @Getter private String email;
    @Getter private String photo;
    @Getter private String city;
    @Transient private int age;
    
    @PostLoad
    private void calculateAge() {
        this.age = Period.between(dob, LocalDate.now()).getYears();
    }

    public Student() {}

    public Student(Integer id, String name, LocalDate dob, String email, String photo, String city) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.photo = photo;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" + 
                "id=" + id +
                "name='" + name + '\'' +
                "dob=" + dob +
                "email='" + email + '\'' +
                "photo='" + photo + '\'' + 
                "city='" + city  + '\'' + 
                '}';
    }


}
