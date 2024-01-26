package com.nhnacademy.task.dto.project.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTagRegisterAndModifyResponse {

    private Long projectId;

    private String tagName;

}
