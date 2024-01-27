package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.dto.project.ProjectResponse;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {


    List<ProjectResponse> findAllByUserId(String userId);

    ProjectResponse queryById(Long projectId);


}
