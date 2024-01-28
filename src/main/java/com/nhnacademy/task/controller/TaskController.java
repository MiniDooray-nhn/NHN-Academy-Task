package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.common.DeleteResponse;
import com.nhnacademy.task.dto.task.TaskDto;
import com.nhnacademy.task.dto.task.TaskPreviewDto;
import com.nhnacademy.task.dto.task.TaskRegisterAndModifyRequest;
import com.nhnacademy.task.dto.task.TaskResponse;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.exception.ValidationFailedException;
import com.nhnacademy.task.repository.TaskRepository;
import com.nhnacademy.task.service.TaskService;
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
public class TaskController {
    private final TaskService taskService;


    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable("id") Long taskId) {
        TaskDto task = taskService.getTaskDetail(taskId);
        if (Objects.isNull(task)) {
            throw new TaskNotFoundException();
        }
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTaskPreview(@RequestParam(name = "projectId")Long projectId){
        List<TaskDto> previewDto = taskService.getTasksByProjectId(projectId);
        return new ResponseEntity<>(previewDto,HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRegisterAndModifyRequest request,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        TaskResponse taskResponse = taskService.createTask(request);
        return new ResponseEntity<>(taskResponse,HttpStatus.CREATED);
    }

    @PutMapping("/tasks")
    public ResponseEntity<TaskDto> modifyTask(@Valid @RequestBody TaskRegisterAndModifyRequest request,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        TaskDto taskDto = taskService.modifyTask(request);
        return new ResponseEntity<>(taskDto,HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<DeleteResponse> deleteTask(@PathVariable("id") Long taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(new DeleteResponse("OK"),HttpStatus.OK);
    }
}
