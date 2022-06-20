package com.example.rest_company.mapper.edit;

import com.example.rest_company.dto.request.TeacherRequest;
import com.example.rest_company.entity.Teacher;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Component
public class TeacherEditMapper {

    public Teacher create(TeacherRequest request){
        if(request == null){
         return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setLocalDate(LocalDate.now());
        return teacher;
    }
    public void update(Teacher teacher, TeacherRequest request){
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
    }
}
