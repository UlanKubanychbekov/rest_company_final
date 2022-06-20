package com.example.rest_company.api;

import com.example.rest_company.dto.request.StudentRequest;
import com.example.rest_company.dto.response.StudentResponse;
import com.example.rest_company.entity.Student;
import com.example.rest_company.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Ulansky
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
public class StudentApi {
    private final StudentService service;

    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest request) {
        return service.create(request);

    }

    @PutMapping("/update/{id}")
    public StudentResponse update(@PathVariable long id, @RequestBody StudentRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public StudentResponse delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/find/{id}")
    public StudentResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping
    public List<StudentResponse> getAll() {
        return service.getAllStudents();
    }
}
