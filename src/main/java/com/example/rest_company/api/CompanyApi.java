package com.example.rest_company.api;

import com.example.rest_company.dto.request.CompanyRequest;
import com.example.rest_company.dto.response.CompanyResponse;
import com.example.rest_company.dto.response.CompanyResponseView;
import com.example.rest_company.service.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Ulansky
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/companies")
@Tag(name = "Company API", description = "SUPER_ADMIN can add , update ,delete")
@PreAuthorize("hasAuthority('ADMIN')")
public class CompanyApi {

    private final CompanyService service;

    @PostMapping
    @Operation(summary = "create company", description = "we can create company")
    public CompanyResponse create(@RequestBody CompanyRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update company", description = "we can update company")
    public CompanyResponse update(@PathVariable long id, @RequestBody CompanyRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/find/{id}")
    @Operation(summary = "find company", description = "we can find company by id")
    public CompanyResponse findById(@PathVariable long id) {
        return service.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete company", description = "we can delete company by id")
    public CompanyResponse delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping
    public List<CompanyResponse> getAllCompanies() {
        return service.getAllCompanies();

    }
    @GetMapping("search")
    @Operation(summary = "Get allCompanyAndSearch", description = "we can get all company and search")
    public CompanyResponseView getAllCompanies(@RequestParam(name = "text", required = false)String text,
                                               @RequestParam int page,
                                               @RequestParam int size){
        return service.getAllCompanyPagination(text, page, size);
    }
}