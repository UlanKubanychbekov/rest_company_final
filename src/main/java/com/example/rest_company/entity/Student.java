package com.example.rest_company.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fisrt_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "email")
    private String email;

    @CreatedDate
    private LocalDate localDate;
    private Boolean enabled;

    @Column(name = "study_format")
    @Enumerated(value = EnumType.STRING)
    private StudyFormat studyFormat;

    @ManyToOne
    private Group group;

}