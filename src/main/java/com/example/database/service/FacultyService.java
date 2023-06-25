package com.example.database.service;

import com.example.database.dto.FacultyDtoIn;
import com.example.database.dto.FacultyDtoOut;
import com.example.database.entity.Faculty;
import com.example.database.mapper.FacultyMapper;
import com.example.database.repository.FacultyRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FacultyService {


    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    public FacultyService(FacultyRepository facultyRepository, FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
    }


    public FacultyDtoOut addFaculty(FacultyDtoIn facultyDtoIn) {
        return facultyMapper
                .toDto(facultyRepository
                        .save(facultyMapper
                                .toEntity(facultyDtoIn)));
    }

    public FacultyDtoOut getFaculty(long id) {
        return facultyRepository.findById(id)
                .map(facultyMapper::toDto)
                .orElseThrow();
    }

    public FacultyDtoOut setFaculty(long id, FacultyDtoIn facultyDtoIn) {
        return facultyRepository.findById(id)
                .map(oldFaculty -> {
                    oldFaculty.setColor(facultyDtoIn.getColor());
                    oldFaculty.setName(facultyDtoIn.getName());
                    return facultyMapper.toDto(facultyRepository.save(oldFaculty));
                })
                .orElseThrow();
    }

    public FacultyDtoOut deleteFaculty(long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow();
        facultyRepository.delete(faculty);
        return facultyMapper.toDto(faculty);
    }

    public Collection<FacultyDtoOut> facultyCollection(String color) {
        return Optional.ofNullable(color)
                .map(facultyRepository::findAllByColor)
                .orElseGet(facultyRepository::findAll)
                .stream()
                .map(facultyMapper::toDto)
                .collect(Collectors.toList());
    }
}
