package com.nhnacademy.task.dto.comment;

import com.nhnacademy.task.domain.Task;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRegisterAndModifyRequest {
    private Long id;

    private String contents;

    private String userId;

    private Long taskId;
}
