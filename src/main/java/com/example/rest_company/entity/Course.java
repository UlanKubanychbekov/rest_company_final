package com.example.rest_company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String data;
    @CreatedDate
    private LocalDate localDate;
    private Boolean enabled;

    @JsonIgnore
    @ManyToOne
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "courses", cascade = {CascadeType.MERGE, CascadeType.REMOVE} )
    private List<Group> groups;

    @OneToOne(mappedBy = "course", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Teacher teacher;

}
