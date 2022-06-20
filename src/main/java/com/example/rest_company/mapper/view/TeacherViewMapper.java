package com.example.rest_company.mapper.view;

import com.example.rest_company.dto.response.StudentResponse;
import com.example.rest_company.dto.response.TeacherResponse;
import com.example.rest_company.entity.Teacher;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Component
public class TeacherViewMapper {

    public TeacherResponse view(Teacher teacher){
        if(teacher == null){
            return null;
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setEmail(teacher.getEmail());
        teacherResponse.setEnabled(teacher.getEnabled());
        teacherResponse.setLocalDate(teacher.getLocalDate());
        return teacherResponse;
    }

    public List<TeacherResponse> getAllTeacher(List<Teacher> teachers){
        List<TeacherResponse> teacherResponses = new ArrayList<>();
        for(Teacher teacher : teachers){
            teacherResponses.add(view(teacher));
        }
        return teacherResponses;
    }

}
