package com.example.rest_company.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * author: Ulansky
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private  Role role;
}
