package com.example.rest_company.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Getter@Setter
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate localDate;
    private Boolean enabled;
}
