package com.example.database.service;

import com.example.database.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final HashMap<Long, Student> studentHashMap = new HashMap<>();

    private long lastId = 0;

    public Student addStudent(Student student) {
        student.setId(++lastId);
        studentHashMap.put(lastId, student);
        return student;
    }

    public Student getStudent(long id) {
        return studentHashMap.get(id);
    }

    public Student setStudent(Student student) {
        studentHashMap.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return studentHashMap.remove(id);
    }

    public Collection<Student> studentCollection(int age) {
        return studentHashMap.values().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }
}
