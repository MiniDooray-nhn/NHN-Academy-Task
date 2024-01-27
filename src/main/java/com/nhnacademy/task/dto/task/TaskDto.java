package com.nhnacademy.task.dto.task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskDto {
    Long getId();

    String getUserId();

    String getTitle();

    String getContents();

    LocalDateTime getCreatedAt();

    List<Project> getProject();

    interface Project {
        Long getId();
    }

}
