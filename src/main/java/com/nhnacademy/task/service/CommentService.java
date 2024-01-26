package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.Comment;
import com.nhnacademy.task.domain.Task;
import com.nhnacademy.task.dto.comment.CommentDto;
import com.nhnacademy.task.dto.comment.CommentRegisterAndModifyRequest;
import com.nhnacademy.task.dto.comment.CommentResponse;
import com.nhnacademy.task.exception.CommentNotFoundException;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.repository.CommentRepository;
import com.nhnacademy.task.repository.TaskRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public List<CommentDto> getAllCommentByTaskId(Long id) {
        return commentRepository.findByTaskId(id);
    }


    public CommentResponse createComment(CommentRegisterAndModifyRequest request) {
        Task task = taskRepository.getReferenceById(request.getTaskId());
        Comment commentTmp =
                new Comment(request.getId(), request.getContents(), request.getUserId(), LocalDateTime.now(),
                        task);
        Comment comment = commentRepository.save(commentTmp);
        return CommentResponse.create(comment);
    }

    public void deleteTask(Long id) {
        commentRepository.deleteById(id);
    }

    public CommentDto getCommentDetail(Long id) {
        CommentDto commentDto = commentRepository.queryById(id);
        if (commentDto == null) {
            throw new CommentNotFoundException();
        }
        return commentDto;
    }

    public CommentDto modifyComment(CommentRegisterAndModifyRequest request) {
        Optional<Comment> optionalComment = commentRepository.findById(request.getId());

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            comment.setContents(request.getContents());
            comment.setCreatedAt(LocalDateTime.now());
            commentRepository.save(comment);
            return commentRepository.queryById(request.getId());
        }
        throw new CommentNotFoundException();
    }
}
