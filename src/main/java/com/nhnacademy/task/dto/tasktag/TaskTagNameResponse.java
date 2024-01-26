package com.nhnacademy.task.dto.tasktag;

import com.nhnacademy.task.domain.TaskTag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class TaskTagNameResponse {

    private Long id;

    private String tagName;


    public static TaskTagNameResponse create(TaskTag tasktag, String tagName) {
        return new TaskTagNameResponse(tasktag.getId(), tagName);
    }
}

