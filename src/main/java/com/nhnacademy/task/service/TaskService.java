package com.nhnacademy.task.service;


import com.nhnacademy.task.domain.Task;
import com.nhnacademy.task.dto.task.TaskDto;
import com.nhnacademy.task.dto.task.TaskRegisterAndModifyRequest;
import com.nhnacademy.task.dto.task.TaskResponse;
import com.nhnacademy.task.exception.TaskNotFoundException;
import com.nhnacademy.task.repository.TaskRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
//    private final ProjectRepository projectRepository;

    //TODO Task가 아니라 Dto만들어서 뿌릴것
    @Transactional(readOnly = true)
    public List<Task> getTasksByProjectId(Long id) {
        return taskRepository.findByProjectIdOrderByCreatedAt(id);
    }

    public TaskResponse createTask(TaskRegisterAndModifyRequest request) {
//        Project project =
        Task taskTmp = new Task(request.getId(), request.getUserId(), request.getTitle(), request.getContents(),
                LocalDateTime.now(), null);
//                , request.getProject());
//        Task task = taskRepository.save(taskTmp);
        return TaskResponse.create(taskTmp);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public TaskDto getTaskDetail(Long id) {
        TaskDto taskDto = taskRepository.queryById(id);
        if (taskDto == null) {
            throw new TaskNotFoundException();
        }
        return taskDto;
    }

    public TaskDto modifyTask(TaskRegisterAndModifyRequest request) {
        Optional<Task> optionalTask = taskRepository.findById(request.getId());

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setContents(request.getContents());
            task.setTitle(request.getTitle());
            task.setCreatedAt(LocalDateTime.now());
            taskRepository.save(task);
            return taskRepository.queryById(request.getId());
        }
        throw new TaskNotFoundException();
    }
}
