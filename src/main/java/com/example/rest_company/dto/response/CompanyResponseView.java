package com.example.rest_company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * author: Ulansky
 */
@Getter
@Setter
public class CompanyResponseView {
    List<CompanyResponse> responses;
}
