package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.Task;
import com.nhnacademy.task.dto.task.TaskDto;
import com.nhnacademy.task.dto.task.TaskPreviewDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<TaskPreviewDto> findByProjectIdOrderByCreatedAt(Long id);
    TaskDto queryById(Long id);


}

