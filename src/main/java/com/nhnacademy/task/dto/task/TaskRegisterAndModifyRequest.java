package com.nhnacademy.task.dto.task;

import com.nhnacademy.task.domain.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskRegisterAndModifyRequest {
    //TODO Validation 설정
    private Long id;

    private String userId;

    private String title;

    private String contents;

    private Long projectId;

}
