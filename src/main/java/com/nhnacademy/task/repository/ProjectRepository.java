package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.Project;
import com.nhnacademy.task.dto.ProjectRegisterResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {


    ProjectRegisterResponse queryById(Long projectId);

}
