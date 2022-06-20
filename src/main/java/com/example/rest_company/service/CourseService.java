package com.example.rest_company.service;

import com.example.rest_company.dto.request.CompanyRequest;
import com.example.rest_company.dto.request.CourseRequest;
import com.example.rest_company.dto.response.CompanyResponse;
import com.example.rest_company.dto.response.CourseResponse;
import com.example.rest_company.entity.Company;
import com.example.rest_company.entity.Course;
import com.example.rest_company.mapper.edit.CompanyEditMapper;
import com.example.rest_company.mapper.edit.CourseEditMapper;
import com.example.rest_company.mapper.view.CompanyViewMapper;
import com.example.rest_company.mapper.view.CourseViewMapper;
import com.example.rest_company.repository.CompanyRepo;
import com.example.rest_company.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Ulansky
 */
@Service
@RequiredArgsConstructor
public class CourseService {

    private  final CourseRepo courseRepo;
    private final CourseEditMapper courseEditMapper;
    private  final CourseViewMapper courseViewMapper;

    public CourseResponse create(CourseRequest courseRequest){
        Course course = courseEditMapper.create(courseRequest);
        courseRepo.save(course);
        return courseViewMapper.viewCourse(course);
    }

    public  CourseResponse update(long id, CourseRequest courseyRequest){
        Course course = courseRepo.findById(id).get();
        courseEditMapper.update(course,courseyRequest);
        return  courseViewMapper.viewCourse(courseRepo.save(course));

    }
    public  CourseResponse findById(long id){
        Course course = courseRepo.findById(id).get();
        return courseViewMapper.viewCourse(course);
    }
    public  CourseResponse delete(long id){
        Course course = courseRepo.getById(id);
        courseRepo.delete(course);
        return courseViewMapper.viewCourse(course);

    }
    public List<CourseResponse> getAllCourses(){
        return courseViewMapper.view(courseRepo.findAll());

    }
}
