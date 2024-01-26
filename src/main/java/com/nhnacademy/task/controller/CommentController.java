package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.comment.CommentDto;
import com.nhnacademy.task.dto.comment.CommentRegisterAndModifyRequest;
import com.nhnacademy.task.dto.comment.CommentResponse;
import com.nhnacademy.task.dto.common.DeleteResponse;
import com.nhnacademy.task.exception.ValidationFailedException;
import com.nhnacademy.task.service.CommentService;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    @GetMapping("/comments/{id}")
    public ResponseEntity<List<CommentDto>> getCommentByTaskId(@PathVariable("id") Long taskId) {
        List<CommentDto> commentDtoList = commentService.getAllCommentByTaskId(taskId);

        return new ResponseEntity<>(commentDtoList,HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentResponse> createComment(@Valid @RequestBody CommentRegisterAndModifyRequest request,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        CommentResponse commentResponse =  commentService.createComment(request);
        return new ResponseEntity<>(commentResponse,HttpStatus.CREATED);
    }

    @PutMapping("/comments")
    public ResponseEntity<CommentDto> modifyComment(@Valid @RequestBody CommentRegisterAndModifyRequest request,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        CommentDto commentDto = commentService.modifyComment(request);
        return new ResponseEntity<>(commentDto,HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<DeleteResponse> deleteComment(@PathVariable("id") Long commentId) {
            commentService.deleteTask(commentId);
        return new ResponseEntity<>(new DeleteResponse("OK"),HttpStatus.OK);

    }
}
