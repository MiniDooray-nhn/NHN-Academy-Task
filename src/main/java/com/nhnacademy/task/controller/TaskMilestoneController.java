package com.nhnacademy.task.controller;

import com.nhnacademy.task.domain.Task;
import com.nhnacademy.task.domain.TaskMilestone;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyResponse;
import com.nhnacademy.task.service.TaskMilestoneService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task/milestone")
public class TaskMilestoneController {

    private final TaskMilestoneService taskMilestoneService;

    public TaskMilestoneController(TaskMilestoneService taskMilestoneService) {
        this.taskMilestoneService = taskMilestoneService;
    }

    @GetMapping("/task")
    public TaskMilestone getTaskMilestone(){
        List<TaskMilestoneRegisterAndModifyResponse> taskMilestoneRegisterAndModifyResponseList =
                taskMilestoneService.getTaskMilestones()
    }

    @PostMapping
    public ResponseEntity<TaskMilestoneRegisterAndModifyResponse> registerTaskMilestone(
            @RequestBody TaskMilestoneRegisterAndModifyRequest registerRequest){

        TaskMilestoneRegisterAndModifyResponse taskMilestoneRegisterAndModifyResponse =
                taskMilestoneService.
    }



    }

