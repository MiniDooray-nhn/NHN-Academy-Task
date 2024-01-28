package com.nhnacademy.task.dto.tasktag;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.domain.ProjectTag;
import com.nhnacademy.task.domain.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskTagRegisterAndModifyRequest {
    private Long id;

    private Task task;

    private ProjectTag projectTag;
}
