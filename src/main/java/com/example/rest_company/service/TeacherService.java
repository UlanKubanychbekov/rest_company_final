package com.example.rest_company.service;

import com.example.rest_company.dto.request.TeacherRequest;
import com.example.rest_company.dto.response.TeacherResponse;
import com.example.rest_company.entity.Course;
import com.example.rest_company.entity.Teacher;
import com.example.rest_company.mapper.edit.TeacherEditMapper;
import com.example.rest_company.mapper.view.TeacherViewMapper;
import com.example.rest_company.repository.CourseRepo;
import com.example.rest_company.repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

/**
 * author: Ulansky
 */
@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherViewMapper viewMapper;
    private final CourseRepo courseRepo;
    private final TeacherEditMapper editMapper;
    private final TeacherRepo repo;

    public TeacherResponse create(Long id,TeacherRequest teacherRequest) {
        Course course = courseRepo.findById(id).orElseThrow(()->new NotFoundException(
                "Course with this id "+id +"doesn't exists!"));
        Teacher teacher = editMapper.create(teacherRequest);
        repo.save(teacher);
        teacher.setCourse(course);
        return viewMapper.view(teacher);
    }

    public TeacherResponse update(long id, TeacherRequest request) {
        Teacher teacher = repo.findById(id).get();
        editMapper.update(teacher, request);
        return viewMapper.view(teacher);
    }

    public TeacherResponse findById(long id) {
        Teacher teacher = repo.findById(id).get();
        return viewMapper.view(teacher);

    }

    public TeacherResponse delete(long id) {
        Teacher teacher = repo.getById(id);
        repo.delete(teacher);
        return viewMapper.view(teacher);
    }

    public List<TeacherResponse> getAll(){
        return viewMapper.getAllTeacher(repo.findAll());
    }
}
