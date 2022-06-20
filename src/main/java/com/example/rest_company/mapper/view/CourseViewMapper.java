package com.example.rest_company.mapper.view;

import com.example.rest_company.dto.response.CourseResponse;
import com.example.rest_company.entity.Course;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course){

        if(course == null){
            return  null;
        }
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setData(course.getData());
        courseResponse.setEnabled(course.getEnabled());
        courseResponse.setLocalDate(LocalDate.now());

        return courseResponse;
    }

    public List<CourseResponse> view(List<Course> courses){
        List<CourseResponse> courseResponses = new ArrayList<>();
        for(Course course : courses){
            courseResponses.add(viewCourse(course));
        }

        return courseResponses;
    }
}
