package com.nhnacademy.task.dto.comment;

import com.nhnacademy.task.domain.Comment;
import com.nhnacademy.task.domain.Task;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponse {

    private Long id;

    private String contents;

    private String userId;

    private LocalDateTime createdAt;

    private Task task;

    public static CommentResponse create(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getContents(), comment.getUserId(), comment.getCreatedAt(),
                comment.getTask());
    }
}
