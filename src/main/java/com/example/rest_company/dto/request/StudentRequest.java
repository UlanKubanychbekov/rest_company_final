package com.example.rest_company.dto.request;

import com.example.rest_company.entity.StudyFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Getter@Setter
public class StudentRequest {

    private String firstName;
    private String lastname;
    private String email;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;

}
