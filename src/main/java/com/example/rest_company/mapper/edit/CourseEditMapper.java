package com.example.rest_company.mapper.edit;

import com.example.rest_company.dto.request.CourseRequest;
import com.example.rest_company.entity.Course;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Component
public class CourseEditMapper {

    public Course create(CourseRequest courseRequest){
        if(courseRequest == null){
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setData(courseRequest.getData());
        course.setLocalDate(LocalDate.now());
        return course;
    }

    public void update(Course course, CourseRequest courseRequest){
        course.setCourseName(courseRequest.getCourseName());
        course.setData(courseRequest.getData());


    }
}
