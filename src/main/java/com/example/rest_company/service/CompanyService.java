package com.example.rest_company.service;

import com.example.rest_company.dto.request.CompanyRequest;
import com.example.rest_company.dto.response.CompanyResponse;
import com.example.rest_company.entity.Company;
import com.example.rest_company.mapper.edit.CompanyEditMapper;
import com.example.rest_company.mapper.view.CompanyViewMapper;
import com.example.rest_company.repository.CompanyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
