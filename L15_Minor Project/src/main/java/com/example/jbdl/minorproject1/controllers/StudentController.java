package com.example.jbdl.minorproject1.controllers;

import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.requests.StudentCreateRequest;
import com.example.jbdl.minorproject1.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@Valid @RequestBody StudentCreateRequest studentCreateRequest){
        studentService.createStudent(studentCreateRequest.to());
    }

    @GetMapping("/student/all")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable("studentId") int studentId){
        return studentService.getStudentById(studentId);
    }
}
