package com.example.rest_company.repository;

import com.example.rest_company.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
