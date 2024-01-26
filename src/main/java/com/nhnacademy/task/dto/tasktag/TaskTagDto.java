package com.nhnacademy.task.dto.tasktag;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.domain.ProjectTag;
import com.nhnacademy.task.domain.Task;

public interface TaskTagDto {
    Long getId();

    Task getTask();

    ProjectTag getProjectTag();
}
