package com.example.database.mapper;

import com.example.database.dto.FacultyDtoIn;
import com.example.database.dto.FacultyDtoOut;
import com.example.database.entity.Faculty;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {
    public FacultyDtoOut toDto(Faculty faculty) {
        FacultyDtoOut facultyDtoOut = new FacultyDtoOut();
        facultyDtoOut.setId(faculty.getId());
        facultyDtoOut.setName(faculty.getName());
        facultyDtoOut.setColor(faculty.getColor());
        return facultyDtoOut;
    }

    public Faculty toEntity(FacultyDtoIn facultyDtoIn) {
        Faculty faculty = new Faculty();
        faculty.setColor(facultyDtoIn.getColor());
        faculty.setName(facultyDtoIn.getName());
        return faculty;
    }
}
