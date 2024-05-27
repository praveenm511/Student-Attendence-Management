package com.learning.java.service;

import com.learning.java.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudent();

    public Optional<Student> findById(int id);

    public Student saveStudent(Student student);

    public Student updateStudent(Long id,Student student);
}
