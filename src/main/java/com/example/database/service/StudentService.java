package com.example.database.service;

import com.example.database.dto.StudentDtoIn;
import com.example.database.dto.StudentDtoOut;
import com.example.database.entity.Student;
import com.example.database.mapper.StudentMapper;
import com.example.database.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {


    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDtoOut addStudent(StudentDtoIn studentDtoIn) {
        return studentMapper
                .toDto(studentRepository
                        .save(studentMapper
                                .toEntity(studentDtoIn)));
    }

    public StudentDtoOut getStudent(long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow();
    }

    public StudentDtoOut setStudent(long id, StudentDtoIn studentDtoIn) {
        return studentRepository.findById(id)
                .map(oldStudent -> {
                    oldStudent.setAge(studentDtoIn.getAge());
                    oldStudent.setName(studentDtoIn.getName());
                    return studentMapper.toDto(studentRepository.save(oldStudent));
                })
                .orElseThrow();
    }

    public StudentDtoOut deleteStudent(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow();
        studentRepository.delete(student);
        return studentMapper.toDto(student);
    }

    public Collection<StudentDtoOut> studentCollection(Integer age) {
        return Optional.ofNullable(age)
                .map(studentRepository::findAllByAge)
                .orElseGet(studentRepository::findAll)
                .stream()
                .map(studentMapper::toDto)
                .collect(Collectors.toList());
    }
}
