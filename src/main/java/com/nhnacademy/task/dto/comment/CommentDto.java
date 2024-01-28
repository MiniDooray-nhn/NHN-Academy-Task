package com.nhnacademy.task.dto.comment;

import java.time.LocalDateTime;

public interface CommentDto {
    Long getId();

    String getContents();

    String getUserId();

    LocalDateTime getCreatedAt();

    interface TaskDto {
        Long getId();
    }
}
