package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.common.DeleteResponse;
import com.nhnacademy.task.dto.task.TaskDto;
import com.nhnacademy.task.dto.task.TaskRegisterAndModifyRequest;
import com.nhnacademy.task.dto.task.TaskResponse;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.exception.ValidationFailedException;
import com.nhnacademy.task.service.TaskService;
import java.util.Objects;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class TaskController {
    private final TaskService taskService;


    @GetMapping("/tasks/{id}")
    public TaskDto getTask(@PathVariable("id") Long taskId) {
        TaskDto task = taskService.getTaskDetail(taskId);
        if (Objects.isNull(task)) {
            throw new TaskNotFoundException();
        }
        return task;
    }

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(@Valid @RequestBody TaskRegisterAndModifyRequest request,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        return taskService.createTask(request);
    }

    @PutMapping("/tasks")
    public TaskDto modifyTask(@Valid @RequestBody TaskRegisterAndModifyRequest request,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        return taskService.modifyTask(request);
    }

    @DeleteMapping("/tasks/{id}")
    public DeleteResponse deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return new DeleteResponse("OK");
    }
}
