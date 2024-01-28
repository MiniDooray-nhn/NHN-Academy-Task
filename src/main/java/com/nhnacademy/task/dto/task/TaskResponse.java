package com.nhnacademy.task.dto.task;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.domain.Task;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskResponse {

    private Long id;

    private String userId;

    private String title;

    private String contents;

    private LocalDateTime createdAt;

    private Project project;

    public static TaskResponse create(Task task) {
        return new TaskResponse(task.getId(), task.getUserId(), task.getTitle(), task.getContents(),
                task.getCreatedAt(), task.getProject());
    }
}
