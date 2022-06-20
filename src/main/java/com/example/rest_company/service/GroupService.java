package com.example.rest_company.service;

import com.example.rest_company.dto.request.GroupRequest;
import com.example.rest_company.dto.response.CourseResponse;
import com.example.rest_company.dto.response.GroupResponse;
import com.example.rest_company.entity.Group;
import com.example.rest_company.mapper.edit.GroupEditMapper;
import com.example.rest_company.mapper.view.GroupViewMapper;
import com.example.rest_company.repository.GroupRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: Ulansky
 */
@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupEditMapper groupEditMapper;
    private final GroupViewMapper groupViewMapper;
    private final GroupRepo repo;

    public GroupResponse create (GroupRequest groupRequest){
        Group group = groupEditMapper.create(groupRequest);
        repo.save(group);
        return groupViewMapper.viewGroup(group);
    }

    public GroupResponse update(long id, GroupRequest request){
        Group group = repo.findById(id).get();
        groupEditMapper.update(group,request);
        return groupViewMapper.viewGroup(group);
    }
    public GroupResponse findById(long id){
        Group group = repo.findById(id).get();
        return groupViewMapper.viewGroup(group);
    }

    public GroupResponse delete(long id){
        Group group = repo.getById(id);
        repo.delete(group);
        return groupViewMapper.viewGroup(group);
    }

    public List<GroupResponse> getAllGroup(){
        return groupViewMapper.getAllGroups(repo.findAll());

     }

}
