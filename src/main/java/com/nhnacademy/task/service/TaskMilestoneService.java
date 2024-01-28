package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.domain.ProjectMilestone;
import com.nhnacademy.task.domain.Task;
import com.nhnacademy.task.domain.TaskMilestone;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyResponse;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRequest;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneResponse;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.repository.ProjectMileStoneRepository;
import com.nhnacademy.task.repository.ProjectRepository;
import com.nhnacademy.task.repository.TaskMilestoneRepository;
import com.nhnacademy.task.repository.TaskRepository;
import java.util.List;
import org.aspectj.weaver.AnnotationTargetKind;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class TaskMilestoneService {
    private TaskMilestoneRepository taskMilestoneRepository;
    private ProjectMileStoneRepository projectMileStoneRepository;
    private TaskRepository taskRepository;

    public TaskMilestoneService(TaskMilestoneRepository taskMilestoneRepository, ProjectMileStoneRepository projectMileStoneRepository, TaskRepository taskRepository) {
        this.taskMilestoneRepository = taskMilestoneRepository;
        this.projectMileStoneRepository = projectMileStoneRepository;
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<TaskMilestoneResponse> getTaskMilestones() {

        return  taskMilestoneRepository.findAllBy();
    }

    public TaskMilestoneResponse createTaskMilestone(TaskMilestoneRequest taskMilestoneRequest) {
        ProjectMilestone projectMilestone = projectMileStoneRepository.findById(taskMilestoneRequest.getProjectMilestoneId()).orElse(null);
        Task task = taskRepository.findById(taskMilestoneRequest.getTaskId()).orElse(null);
        TaskMilestone taskMilestone = new TaskMilestone(task,projectMilestone);
        taskMilestoneRepository.save(taskMilestone);
        return new TaskMilestoneResponse(taskMilestone.getId(),task.getId(),projectMilestone.getId()); // 들어온 값
    }

    @Transactional(readOnly = true)
    public TaskMilestoneResponse getTaskMilestone(Long id) {
        return taskMilestoneRepository.findAllById(id).orElse(null);
    }

    public TaskMilestoneResponse updateMilestone(Long id ,TaskMilestoneRequest taskMilestoneRequest) {
        TaskMilestone taskMilestone = taskMilestoneRepository.findById(id).orElse(null);

        ProjectMilestone projectMilestone = projectMileStoneRepository.findById(taskMilestoneRequest.getProjectMilestoneId()).orElse(null);
        Task task = taskRepository.findById(taskMilestoneRequest.getTaskId()).orElse(null);

        TaskMilestone updateMilestone = taskMilestone.updateTaskMilestone(task, projectMilestone);
        taskMilestoneRepository.save(updateMilestone);
        return new TaskMilestoneResponse(id,task.getId(),projectMilestone.getId()); // 들어온 값
    }

    public void deleteTaskMilestone(Long id) {
        TaskMilestone taskMilestone = taskMilestoneRepository.findById(id).orElse(null);
        taskMilestoneRepository.delete(taskMilestone);

    }
}
