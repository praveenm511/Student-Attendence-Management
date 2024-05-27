package com.learning.java.service.impl;

import com.learning.java.Exception.EntityNotFound;
import com.learning.java.model.Student;
import com.learning.java.repository.StudentRepository;
import com.learning.java.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById((long)id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Long id,Student student) {
        try{
            Student existingStudent = studentRepository.findById(id).orElseThrow(()->new EntityNotFound("Student not found"));
            existingStudent.setName(student.getName());
            existingStudent.setAddress(student.getAddress());
            existingStudent.setDepartment(student.getDepartment());
            studentRepository.save(existingStudent);
            return existingStudent;
        }catch (EntityNotFound entityNotFound){
            throw entityNotFound;
        }catch (Exception exception){
            throw exception;
        }
    }
}
