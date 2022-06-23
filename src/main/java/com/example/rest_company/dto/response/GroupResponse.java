package com.example.rest_company.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * author: Ulansky
 */
@Getter@Setter
public class GroupResponse {
    private Long id;
    private String groupName;
    private String startData;
    private String finishDate;
    private LocalDate localDate;
    private Boolean enabled;

}
