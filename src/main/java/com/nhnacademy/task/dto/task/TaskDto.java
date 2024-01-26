package com.nhnacademy.task.dto.task;

import java.time.LocalDateTime;

public interface TaskDto {
    Long getId();

    String getUserId();

    String getTitle();

    String getContents();

    LocalDateTime getCreatedAt();

    interface ProjectDto {
        Long getId();
    }

}
