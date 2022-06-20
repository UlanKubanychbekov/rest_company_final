package com.example.rest_company.api;

import com.example.rest_company.dto.request.TeacherRequest;
import com.example.rest_company.dto.response.TeacherResponse;
import com.example.rest_company.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Ulansky
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/teacher")
public class TeacherApi {

    private final TeacherService service;

    @PostMapping
    public TeacherResponse create(@RequestBody TeacherRequest request) {
        return service.create(request);

    }

    @PutMapping("/update/{id}")
    public TeacherResponse update(@PathVariable long id, @RequestBody TeacherRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    public TeacherResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public TeacherResponse delete(@PathVariable long id) {
        return service.delete(id);
    }
    @GetMapping
    public List<TeacherResponse> getAll(){
        return service.getAll();
    }
}
