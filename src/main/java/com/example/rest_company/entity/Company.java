package com.example.rest_company.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * author: Ulansky
 */
@Entity
@Table(name = "companies")
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String locatedCountry;


    @CreatedDate
    private LocalDate localDate;
    private Boolean enabled;

    @OneToMany(fetch=FetchType.EAGER ,cascade = {CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "company")
    private List<Course> courses;


}
