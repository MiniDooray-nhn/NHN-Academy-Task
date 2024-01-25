package com.nhnacademy.task.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProjectRegisterAndModifyRequest {

    private String userId;

    private Integer projectStatusId;

    private String title;



}
