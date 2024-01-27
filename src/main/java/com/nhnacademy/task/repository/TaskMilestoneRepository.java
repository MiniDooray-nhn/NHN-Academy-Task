package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.TaskMilestone;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneRegisterAndModifyResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskMilestoneRepository extends JpaRepository<TaskMilestone, Long> {
    // select * from TaskMilestone where id = ?
//    List<TaskMilestone> findAllById(Long id);

    List<TaskMilestoneRegisterAndModifyResponse> findAllBy();

    Optional<TaskMilestoneRegisterAndModifyResponse> findAllById(Long id);

}
