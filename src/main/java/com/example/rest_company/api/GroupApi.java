package com.example.rest_company.api;

import com.example.rest_company.dto.request.GroupRequest;
import com.example.rest_company.dto.response.GroupResponse;
import com.example.rest_company.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Ulansky
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/groups")
public class GroupApi {

    private final GroupService service;

    @PostMapping
    public GroupResponse create(@RequestBody GroupRequest request) {
        return service.create(request);
    }

    @PutMapping("/save/{id}")
    public GroupResponse update(@PathVariable long id, @RequestBody GroupRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/delete/{id}")
    public GroupResponse delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/find/{id}")
    public GroupResponse findById(@PathVariable long id) {
        return service.findById(id);
    }
    @GetMapping("{id}")
    public List<GroupResponse> getAllGroups() {
        return service.getAllGroup();
    }
}
