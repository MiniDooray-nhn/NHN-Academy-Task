package com.nhnacademy.task.service;

import com.nhnacademy.task.domain.TaskTag;
import com.nhnacademy.task.dto.tasktag.TaskTagDto;
import com.nhnacademy.task.dto.tasktag.TaskTagRegisterAndModifyRequest;
import com.nhnacademy.task.dto.tasktag.TaskTagResponse;
import com.nhnacademy.task.repository.TaskTagRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskTagService {
    private final TaskTagRepository taskTagRepository;

    public TaskTagResponse createTaskTag(TaskTagRegisterAndModifyRequest request) {
        TaskTag taskTagTmp =
                new TaskTag(request.getId(), request.getTask(), request.getProjectTag());
        TaskTag taskTag = taskTagRepository.save(taskTagTmp);
        return TaskTagResponse.create(taskTag);
    }

    public void deleteTaskTag(Long id) {
        taskTagRepository.deleteById(id);
    }

    //TODO : Dto에서 뭐 뽑아서 보여줄결지결정 , exception 만들기
    public TaskTagDto modifyTaskTag(TaskTagRegisterAndModifyRequest request) {
        Optional<TaskTag> optionalTaskTag = taskTagRepository.findById(request.getId());

        if (optionalTaskTag.isPresent()) {
            TaskTag taskTag = optionalTaskTag.get();
            taskTag.setProjectTag(request.getProjectTag());
            taskTagRepository.save(taskTag);
            return taskTagRepository.queryById(request.getId());
        }
        throw new IllegalArgumentException();
    }
}
