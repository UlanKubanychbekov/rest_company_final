package com.example.rest_company.mapper.edit;

import com.example.rest_company.dto.request.StudentRequest;
import com.example.rest_company.entity.Student;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Component
public class StudentEditMapper {

    public Student create(StudentRequest studentRequest){
        if(studentRequest == null){
            return  null;
        }
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastname(studentRequest.getLastname());
        student.setEmail(studentRequest.getEmail());
        student.setLocalDate(LocalDate.now());
        return student;
    }
    public  void update(Student student, StudentRequest studentRequest){
        student.setFirstName(studentRequest.getFirstName());
        student.setLastname(studentRequest.getLastname());
        student.setEmail(studentRequest.getEmail());
        student.setStudyFormat(studentRequest.getStudyFormat());

    }
}
