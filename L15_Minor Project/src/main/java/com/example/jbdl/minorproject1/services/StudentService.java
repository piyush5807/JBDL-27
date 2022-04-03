package com.example.jbdl.minorproject1.services;

import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).orElse(null);

        // select ref.id, ref.name, ... ref.bookList from student where id = 1;
        // select ref2.id, ref2.name, ref2.student where studentid = 1;

    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}
