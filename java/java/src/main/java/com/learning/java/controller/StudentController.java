package com.learning.java.controller;

import com.learning.java.Exception.EntityNotFound;
import com.learning.java.model.Student;
import com.learning.java.service.StudentService;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = studentService.getAllStudent();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id){
        Optional<Student> student = studentService.findById(id);
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null,HttpStatus.OK);
        }
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        try{
            Student savedStudent = studentService.saveStudent(student);
            return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student){
        try{
            Student updatedStudent = studentService.updateStudent(id,student);
            return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
        }catch (EntityNotFound e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }catch (Exception exception){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
