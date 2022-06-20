package com.example.rest_company.repository;


import com.example.rest_company.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {
}
