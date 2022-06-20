package com.example.rest_company.mapper.view;

import com.example.rest_company.dto.response.StudentResponse;
import com.example.rest_company.entity.Student;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Component
public class StudentViewMapper {

    public StudentResponse view(Student student) {
        if (student == null) {
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(student.getId());
        studentResponse.setFirstName(student.getFirstName());
        studentResponse.setLastname(student.getLastname());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setStudyFormat(student.getStudyFormat());
        studentResponse.setEnabled(student.getEnabled());
        studentResponse.setLocalDate(student.getLocalDate());

        return studentResponse;

    }

    public List<StudentResponse> getAllStudents(List<Student> students){
        List<StudentResponse> studentResponses = new ArrayList<>();
        for(Student student : students){
        studentResponses.add(view(student));
        }
        return studentResponses;
    }


}
