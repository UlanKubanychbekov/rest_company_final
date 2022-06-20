package com.example.rest_company.repository;

import com.example.rest_company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Ulansky
 */
public interface CompanyRepo extends JpaRepository<Company, Long> {

}
