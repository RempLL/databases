package com.example.database.service;

import com.example.database.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final HashMap<Long, Faculty> facultyHashMap = new HashMap<>();

    private long lastId = 0;

    public Faculty addFaculty(Faculty faculty){
        faculty.setId(++lastId);
        facultyHashMap.put(++lastId,faculty);
        return faculty;
    }

    public Faculty getFaculty(long id){
        return facultyHashMap.get(id);
    }

    public Faculty setFaculty(Faculty faculty){
        facultyHashMap.put(faculty.getId(),faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id){
        return facultyHashMap.remove(id);
    }

    public Collection<Faculty> facultyCollection(String color) {
        return facultyHashMap.values().stream()
                .filter(e->e.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
