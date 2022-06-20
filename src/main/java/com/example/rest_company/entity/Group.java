package com.example.rest_company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * author: Ulansky
 */
@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "start_date")
    private String startData;

    @Column(name = "finish_date")
    private String finishDate;
    private String courseName;

    @CreatedDate
    private LocalDate localDate;
    private Boolean enabled;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    private List<Course> courses;

    @OneToMany(mappedBy="group", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Student> students;

    @Transient
    private List<Integer> coursesChoice;

    @ManyToOne
    @JsonIgnore
    private Company company;
}