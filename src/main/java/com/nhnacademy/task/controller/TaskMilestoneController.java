package com.nhnacademy.task.controller;

import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyResponse;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRequest;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneResponse;
import com.nhnacademy.task.service.TaskMilestoneService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task/milestone")
public class TaskMilestoneController {

    private final TaskMilestoneService taskMilestoneService;

    public TaskMilestoneController(TaskMilestoneService taskMilestoneService) {
        this.taskMilestoneService = taskMilestoneService;
    }

    @GetMapping()
    public List<TaskMilestoneResponse> getTaskMilestone() {
        return taskMilestoneService.getTaskMilestones();

    }

    @PostMapping
    public ResponseEntity<TaskMilestoneResponse> registerTaskMilestone(
            @RequestBody TaskMilestoneRequest registerRequest) {

        TaskMilestoneResponse taskMilestone =
                taskMilestoneService.createTaskMilestone(registerRequest);
        return new ResponseEntity<>(taskMilestone, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TaskMilestoneResponse> updateMilestone(@PathVariable Long id,
                                                                 @Valid @RequestBody TaskMilestoneRequest taskMilestoneRequest
    ) {

        TaskMilestoneResponse taskMilestoneResponse = taskMilestoneService.updateMilestone(id, taskMilestoneRequest);
        return new ResponseEntity<>(taskMilestoneResponse, HttpStatus.OK);

    }


}

