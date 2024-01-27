package com.nhnacademy.task.dto.taskmilestone;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskMilestoneRequest {
    private Long taskId;

    private Long projectMilestoneId;
}
