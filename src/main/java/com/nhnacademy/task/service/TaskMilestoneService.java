package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.TaskMilestone;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyResponse;
import java.util.List;

public interface TaskMilestoneService {

    List<TaskMilestoneRegisterAndModifyResponse> getTaskMilestones();

    TaskMilestone createTaskMilestone(TaskMilestone taskMilestone);

    TaskMilestoneRegisterAndModifyResponse getTaskMilestone(Long id);

    TaskMilestoneRegisterAndModifyResponse updateMilestone(Long id, TaskMilestoneRegisterAndModifyRequest taskMilestoneRegisterAndModifyRequest);

    void deleteTaskMilestone(Long id);


}
