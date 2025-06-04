package com.example.CrudRapido.controller;

import com.example.CrudRapido.entity.Student;
import com.example.CrudRapido.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getById(@PathVariable("studentId") Long studentId){
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Student student){
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("/{studentId}")
    public void delete(@PathVariable("studentId") Long studentId){
        studentService.delete(studentId);
    }

}
