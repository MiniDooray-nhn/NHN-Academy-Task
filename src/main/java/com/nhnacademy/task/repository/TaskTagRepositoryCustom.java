package com.nhnacademy.task.repository;

import com.nhnacademy.task.dto.tasktag.TaskTagNameResponse;
import java.util.List;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TaskTagRepositoryCustom {
    List<TaskTagNameResponse> getAllTaskTagsWithName(Long taskId);
}
