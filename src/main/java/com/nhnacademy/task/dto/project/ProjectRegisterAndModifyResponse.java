package com.nhnacademy.task.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRegisterAndModifyResponse {

    private String userId;

    private Integer projectStatusId;

    private String title;
}
