package com.example.rest_company.mapper.view;

import com.example.rest_company.dto.response.CompanyResponse;
import com.example.rest_company.entity.Company;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {

        if (company == null) {
            return null;
        }

        CompanyResponse response = new CompanyResponse();
        response.setId(company.getId());
        response.setCompanyName(company.getCompanyName());
        response.setLocatedCountry(company.getLocatedCountry());
        response.setEnabled(true);
        response.setLocalDate(LocalDate.now());
        return response;
    }

    public List<CompanyResponse> view(List<Company> companies) {
        List<CompanyResponse> responses = new ArrayList<>();
        for (Company company : companies) {
            responses.add(viewCompany(company));
        }
            return responses;

    }
}
