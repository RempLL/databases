package com.example.database.controller;

import com.example.database.dto.StudentDtoIn;
import com.example.database.dto.StudentDtoOut;
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
    public StudentDtoOut delStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("get/{id}")
    public StudentDtoOut getStudent(@PathVariable long id) {
        return studentService.getStudent(id);
    }

    @PutMapping("{id}")
    public StudentDtoOut setStudent(@PathVariable long id, @RequestBody StudentDtoIn studentDtoIn) {
        return studentService.setStudent(id, studentDtoIn);
    }

    @PostMapping("add")
    public StudentDtoOut addStudent(@RequestBody StudentDtoIn studentDtoIn) {
        return studentService.addStudent(studentDtoIn);
    }

    @GetMapping("collect")
    public Collection<StudentDtoOut> studentCollection(int age) {
        return studentService.studentCollection(age);
    }
}
