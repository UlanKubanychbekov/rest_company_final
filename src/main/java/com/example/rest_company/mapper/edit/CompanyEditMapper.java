package com.example.rest_company.mapper.edit;

import com.example.rest_company.dto.request.CompanyRequest;
import com.example.rest_company.entity.Company;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Component
public class CompanyEditMapper {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        company.setEnabled(true);
        company.setLocalDate(LocalDate.now());
        return company;
    }

    public  void  update(Company company, CompanyRequest companyRequest) {

        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }


}
