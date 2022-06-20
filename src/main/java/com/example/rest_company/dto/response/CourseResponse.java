package com.example.rest_company.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Getter
@Setter
public class CourseResponse {

    private Long id;
    private String courseName;
    private String data;
    private LocalDate localDate;
    private Boolean enabled;
}
