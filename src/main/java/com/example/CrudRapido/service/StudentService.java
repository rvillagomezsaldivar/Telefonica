package com.example.CrudRapido.service;

import com.example.CrudRapido.entity.Student;
import com.example.CrudRapido.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(Long id){
        return studentRepository.findById(id);
    }

    /*public Student obtenerPorId(Long id){
        return studentRepository.findById(id).orElse(null);
    }*/

    public void saveOrUpdate(Student student){
        studentRepository.save(student);
    }

    /*public Student guardar(Student student){
        return studentRepository.save(student);
    }*/

    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
