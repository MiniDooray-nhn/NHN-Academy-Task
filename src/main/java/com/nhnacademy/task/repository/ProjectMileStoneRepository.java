package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.ProjectMilestone;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectMileStoneRepository extends JpaRepository<ProjectMilestone, Long> {

    List<ProjectMileStoneResponse> findAllByProjectId(Long projectId);

    Optional<ProjectMileStoneResponse> queryById(Long milestoneId);

}

