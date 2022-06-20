package com.example.rest_company.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Getter@Setter
public class TeacherRequest {
    private String firstName;
    private String lastName;
    private String email;


}
