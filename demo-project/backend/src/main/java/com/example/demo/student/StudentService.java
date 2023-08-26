package com.example.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StudentService {

    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer studentId) {
        Optional<Student> optStudent = studentRepository.findById(studentId);

        if (!optStudent.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find a student with that id.");
        }

        return optStudent.get();
    }

    public void addNewStudent(Student student) {
        Optional<Student> optStudent = studentRepository.findStudentByIdOrEmail(student.getId(), student.getEmail());

        if (optStudent.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A student with that id or email already exists.");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Integer studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't find a student with that id. No items were deleted.");
        }

        studentRepository.deleteById(studentId);
    }
}
