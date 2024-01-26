package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.common.DeleteResponse;
import com.nhnacademy.task.dto.tasktag.TaskTagDto;
import com.nhnacademy.task.dto.tasktag.TaskTagRegisterAndModifyRequest;
import com.nhnacademy.task.exception.ValidationFailedException;
import com.nhnacademy.task.service.TaskTagService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TaskTagController {
    private final TaskTagService taskTagService;

    @PutMapping("/tasktags")
    public TaskTagDto modifyTaskTag(@Valid @RequestBody TaskTagRegisterAndModifyRequest request,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        return taskTagService.modifyTaskTag(request);
    }


    @DeleteMapping("/tasktags/{id}")
    public DeleteResponse deleteTaskTag(@PathVariable("id") Long id) {
        taskTagService.deleteTaskTag(id);
        return new DeleteResponse("OK");
    }
}
