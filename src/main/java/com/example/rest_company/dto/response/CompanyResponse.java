package com.example.rest_company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * author: Ulansky
 */

@Getter@Setter
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private LocalDate localDate;
    private Boolean enabled;
}
