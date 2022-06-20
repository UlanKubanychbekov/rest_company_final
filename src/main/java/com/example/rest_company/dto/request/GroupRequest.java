package com.example.rest_company.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * author: Ulansky
 */
@Getter@Setter
public class GroupRequest {
    private String groupName;
    private String startData;
    private String finishDate;

}
