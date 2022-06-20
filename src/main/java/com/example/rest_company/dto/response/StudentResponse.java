package com.example.rest_company.dto.response;

import com.example.rest_company.entity.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Getter@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastname;
    private StudyFormat studyFormat;
    private String email;
    private LocalDate localDate;
    private Boolean enabled;
}
