package com.example.database.mapper;

import com.example.database.dto.StudentDtoIn;
import com.example.database.dto.StudentDtoOut;
import com.example.database.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDtoOut toDto(Student student) {
        StudentDtoOut studentDtoOut = new StudentDtoOut();
        studentDtoOut.setId(student.getId());
        studentDtoOut.setName(student.getName());
        studentDtoOut.setAge(student.getAge());
        return studentDtoOut;
    }

    public Student toEntity(StudentDtoIn studentDtoIn) {
        Student student = new Student();
        student.setAge(studentDtoIn.getAge());
        student.setName(studentDtoIn.getName());
        return student;
    }
}
