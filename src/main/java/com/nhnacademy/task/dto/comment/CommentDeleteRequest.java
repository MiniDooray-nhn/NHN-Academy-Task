package com.nhnacademy.task.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDeleteRequest {
    private Long commendId;

    private String userId;
}
