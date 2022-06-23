package com.example.rest_company.service;

import com.example.rest_company.dto.request.CompanyRequest;
import com.example.rest_company.dto.response.CompanyResponse;
import com.example.rest_company.dto.response.CompanyResponseView;
import com.example.rest_company.entity.Company;
import com.example.rest_company.mapper.edit.CompanyEditMapper;
import com.example.rest_company.mapper.view.CompanyViewMapper;
import com.example.rest_company.repository.CompanyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Service
@RequiredArgsConstructor
public class CompanyService {

    private  final CompanyRepo companyRepo;
    private final CompanyEditMapper companyMapper;
    private  final CompanyViewMapper companyViewMapper;

    public CompanyResponse create(CompanyRequest companyRequest){
        Company company = companyMapper.create(companyRequest);
        companyRepo.save(company);
        return companyViewMapper.viewCompany(company);
    }

    public  CompanyResponse update(long id, CompanyRequest companyRequest){
        Company company = companyRepo.findById(id).get();
        companyMapper.update(company,companyRequest);
        return  companyViewMapper.viewCompany(companyRepo.save(company));

    }
    public  CompanyResponse findById(long id){
        Company company = companyRepo.findById(id).get();
        return companyViewMapper.viewCompany(company);
    }
    public  CompanyResponse delete(long id){
        Company company = companyRepo.getById(id);
        companyRepo.delete(company);
        return companyViewMapper.viewCompany(company);

}
public List<CompanyResponse> getAllCompanies(){
        return companyViewMapper.view(companyRepo.findAll());

    }

    public CompanyResponseView getAllCompanyPagination(String text, int page, int size) {
        CompanyResponseView responseView = new CompanyResponseView();
        Pageable pageable = PageRequest.of(page -1, size);
        responseView.setResponses(view(search(text,pageable)));
        return responseView;
    }

    public List<CompanyResponse> view(List<Company> companies) {
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company company : companies) {
            responses.add(companyViewMapper.viewCompany(company));
        }
        return responses;
    }

    private List<Company> search(String name, Pageable pageable) {
        String text = name == null ? "" : name;
        return companyRepo.searchAndPagination(text.toUpperCase(), pageable);
    }
}
