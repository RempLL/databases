package com.example.database.controller;

import com.example.database.dto.FacultyDtoIn;
import com.example.database.dto.FacultyDtoOut;
import com.example.database.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @DeleteMapping("delete/{id}")
    public FacultyDtoOut delStudent(@PathVariable long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("get/{id}")
    public FacultyDtoOut getStudent(@PathVariable long id) {
        return facultyService.getFaculty(id);
    }

    @PutMapping("{id}")
    public FacultyDtoOut setStudent(@PathVariable long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.setFaculty(id, facultyDtoIn);
    }

    @PostMapping("add")
    public FacultyDtoOut addStudent(@RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.addFaculty(facultyDtoIn);
    }

    @GetMapping("collect")
    public Collection<FacultyDtoOut> facultyCollection(String color) {
        return facultyService.facultyCollection(color);
    }

}
