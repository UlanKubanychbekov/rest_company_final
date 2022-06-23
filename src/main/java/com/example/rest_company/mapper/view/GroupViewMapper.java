package com.example.rest_company.mapper.view;

import com.example.rest_company.dto.response.GroupResponse;
import com.example.rest_company.entity.Group;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Ulansky
 */
@Component
public class GroupViewMapper {

    public GroupResponse viewGroup(Group group){
        if(group == null){
            return null;
        }
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setStartData(group.getStartData());
        groupResponse.setFinishDate(group.getFinishDate());
        groupResponse.setEnabled(true);
        groupResponse.setLocalDate(group.getLocalDate());
        return groupResponse;
    }
     public List<GroupResponse> getAllGroups(List<Group> groups){
        List<GroupResponse> groupResponses = new ArrayList<>();
        for(Group group : groups){
            groupResponses.add(viewGroup(group));
        }
        return groupResponses;
     }
}
