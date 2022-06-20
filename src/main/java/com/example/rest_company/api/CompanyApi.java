package com.example.rest_company.api;

import com.example.rest_company.dto.request.CompanyRequest;
import com.example.rest_company.dto.response.CompanyResponse;
import com.example.rest_company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Ulansky
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/companies")
public class CompanyApi {

    private final CompanyService service;

    @PostMapping
    public CompanyResponse create(@RequestBody CompanyRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public CompanyResponse update(@PathVariable long id, @RequestBody CompanyRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    public CompanyResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public CompanyResponse delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        return service.getAllCompanies();

    }
}