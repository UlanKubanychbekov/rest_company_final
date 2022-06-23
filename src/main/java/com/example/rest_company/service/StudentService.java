package com.example.rest_company.service;

import com.example.rest_company.dto.request.StudentRequest;
import com.example.rest_company.dto.response.StudentResponse;
import com.example.rest_company.entity.Group;
import com.example.rest_company.entity.Student;
import com.example.rest_company.mapper.edit.StudentEditMapper;
import com.example.rest_company.mapper.view.StudentViewMapper;
import com.example.rest_company.repository.GroupRepo;
import com.example.rest_company.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Service
@RequiredArgsConstructor
public class StudentService {

    private final GroupRepo groupRepo;
    private final StudentEditMapper editMapper;
    private final StudentViewMapper viewMapper;
    private final StudentRepo repo;

    public StudentResponse create(Long id,StudentRequest studentRequest){
        Group group = groupRepo.findById(id).orElseThrow(()->new NotFoundException(
                "Group with "+ id+" id not found!"
        ));
        Student student = editMapper.create(studentRequest);
        repo.save(student);
        student.setGroup(group);
        return viewMapper.view(student);
    }
    public StudentResponse update(long id,StudentRequest request){
        Student student = repo.findById(id).get();
        editMapper.update(student,request);
        return viewMapper.view(student);
    }
    public StudentResponse findById(long id){
         Student student = repo.findById(id).get();
        return viewMapper.view(student);

    }
    public StudentResponse delete(long id){
        Student student = repo.getById(id);
        repo.delete(student);
        return viewMapper.view(student);

    }
    public List<StudentResponse> getAllStudents(){
     return viewMapper.getAllStudents(repo.findAll());
    }

}
