package com.example.rest_company.repository;

import com.example.rest_company.entity.Company;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * author: Ulansky
 */
public interface CompanyRepo extends JpaRepository<Company, Long> {

    @Query("select s from Company s where upper(s.companyName) like concat('%',:text,'%') " +
            "or upper(s.locatedCountry) like concat('%',:text,'%')")
    List<Company> searchAndPagination(@Param("text") String text, Pageable pageable);

}
