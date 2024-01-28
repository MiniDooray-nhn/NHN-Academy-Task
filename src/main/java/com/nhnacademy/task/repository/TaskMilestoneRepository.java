package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.TaskMilestone;
import com.nhnacademy.task.dto.taskmilestone.TaskMilestoneResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskMilestoneRepository extends JpaRepository<TaskMilestone, Long> {
    // select * from TaskMilestone where id = ?
//    List<TaskMilestone> findAllById(Long id);
    @Query("select new com.nhnacademy.task.dto.taskmilestone.TaskMilestoneResponse(T.id, T.task.id, T.projectMilestone.id) from TaskMilestone T")
    List<TaskMilestoneResponse> findAllBy();

    @Query("select new com.nhnacademy.task.dto.taskmilestone.TaskMilestoneResponse(T.id, T.task.id, T.projectMilestone.id) from TaskMilestone T")
    Optional<TaskMilestoneResponse> findAllById(Long id);

}


