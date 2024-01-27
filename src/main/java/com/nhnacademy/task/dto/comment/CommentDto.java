package com.nhnacademy.task.dto.comment;

import java.time.LocalDateTime;

public interface CommentDto {
    Long getId();

    String getContents();

    String getUserId();

    LocalDateTime getCreatedAt();

    Task getTask();

    interface Task {
        Long getId();
    }
}
