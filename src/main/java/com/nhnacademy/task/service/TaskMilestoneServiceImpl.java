package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.TaskMilestone;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyResponse;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneResponse;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.repository.TaskMilestoneRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class TaskMilestoneServiceImpl implements TaskMilestoneService{
    private TaskMilestoneRepository taskMilestoneRepository;

    public TaskMilestoneServiceImpl(TaskMilestoneRepository taskMilestoneRepository) {
        this.taskMilestoneRepository = taskMilestoneRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskMilestoneResponse> getTaskMilestones() {
        return  taskMilestoneRepository.findAllBy();
    }

    @Override
    public TaskMilestoneResponse createTaskMilestone(TaskMilestone taskMilestone) {
        boolean present = taskMilestoneRepository.findById(taskMilestone.getId()).isPresent();
        if (present) {
            throw new IllegalStateException(("already exist " + taskMilestone.getId()));
        }
        return taskMilestoneRepository.save(taskMilestone);
    }

    @Override
    @Transactional(readOnly = true)
    public TaskMilestoneResponse getTaskMilestone(TaskMilestoneRegisterAndModifyRequest id) {
        return taskMilestoneRepository.findAllById(id).orElse(null);
    }

    @Override
    public TaskMilestoneRegisterAndModifyResponse updateMilestone(Long id, TaskMilestoneRegisterAndModifyRequest taskMilestoneRegisterAndModifyRequest) {
        TaskMilestone beforeMilestone = taskMilestoneRepository.findById(id)
                .orElseThrow(TaskNotFoundException::new);

        return new TaskMilestoneRegisterAndModifyResponse(id);
    }

    @Override
    public void deleteTaskMilestone(Long id) {
        taskMilestoneRepository.deleteById(id);

    }
}
