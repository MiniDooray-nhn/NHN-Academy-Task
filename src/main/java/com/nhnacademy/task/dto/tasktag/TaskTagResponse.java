package com.nhnacademy.task.dto.tasktag;

import com.nhnacademy.task.domain.ProjectTag;
import com.nhnacademy.task.domain.Task;
import com.nhnacademy.task.domain.TaskTag;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskTagResponse {

    private Long id;

    private Task task;

    private ProjectTag projectTag;

    public static TaskTagResponse create(TaskTag tasktag) {
        return new TaskTagResponse(tasktag.getId(), tasktag.getTask(), tasktag.getProjectTag());
    }
}
