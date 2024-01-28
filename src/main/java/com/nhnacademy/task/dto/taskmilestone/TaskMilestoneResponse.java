package com.nhnacademy.task.dto.taskmilestone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskMilestoneResponse {
    private Long taskMilestoneId;

    private Long taskId;

    private Long projectMilestoneId;
}
