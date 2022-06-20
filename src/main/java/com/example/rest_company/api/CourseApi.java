package com.example.rest_company.api;

import com.example.rest_company.dto.request.CompanyRequest;
import com.example.rest_company.dto.request.CourseRequest;
import com.example.rest_company.dto.response.CompanyResponse;
import com.example.rest_company.dto.response.CourseResponse;
import com.example.rest_company.service.CompanyService;
import com.example.rest_company.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Ulansky
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/courses")
public class CourseApi {

        private final CourseService service;

        @PostMapping
        public CourseResponse create(@RequestBody CourseRequest request) {
            return service.create(request);
        }

        @PutMapping("/update/{id}")
        public CourseResponse update(@PathVariable long id, @RequestBody CourseRequest request) {
            return service.update(id, request);
        }

        @GetMapping("/find/{id}")
        public CourseResponse findById(@PathVariable long id) {
            return service.findById(id);
        }

        @DeleteMapping("/delete/{id}")
        public CourseResponse delete(@PathVariable long id) {
            return service.delete(id);
        }

        @GetMapping
        public List<CourseResponse> getAllCourses() {
            return service.getAllCourses();

        }
}
