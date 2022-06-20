package com.example.rest_company.mapper.edit;

import com.example.rest_company.dto.request.GroupRequest;
import com.example.rest_company.entity.Group;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Component
public class GroupEditMapper {
    public Group create(GroupRequest request){
        if(request == null){
            return null;
        }
        Group group = new Group();
        group.setGroupName(request.getGroupName());
        group.setStartData(request.getStartData());
        group.setFinishDate(request.getFinishDate());
        group.setLocalDate(LocalDate.now());
        return group;
    }
    public void update(Group group, GroupRequest request){
       group.setGroupName(request.getGroupName());
       group.setStartData(request.getStartData());
       group.setFinishDate(request.getFinishDate());

    }

}
