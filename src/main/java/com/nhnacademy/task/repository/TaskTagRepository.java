package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.TaskTag;
import com.nhnacademy.task.dto.tasktag.TaskTagDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepository extends JpaRepository<TaskTag, Long> {
    TaskTagDto queryById(Long id);
}
