package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.dto.project.ProjectResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {




    ProjectResponse findByProjectId(Long projectId);


}
