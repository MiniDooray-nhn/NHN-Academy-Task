package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.Comment;
import com.nhnacademy.task.dto.comment.CommentDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    CommentDto queryById(Long id);

    List<CommentDto> findByTaskId(Long taskId);
    
}
