package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectStatusRepository extends JpaRepository<ProjectStatus,Integer> {
}
