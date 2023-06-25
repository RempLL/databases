package com.example.database.controller;

import com.example.database.model.Student;
import com.example.database.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @DeleteMapping("delete/{id}")
    public Student delStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @GetMapping("get/{id}")
    public Student getStudent(@PathVariable long id){
        return studentService.getStudent(id);
    }

    @PutMapping("set")
    public Student setStudent(@RequestBody Student student){
        return studentService.setStudent(student);
    }

    @PostMapping("add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("collect")
    public Collection<Student> studentCollection(int age){
        return studentService.studentCollection(age);
    }
}
