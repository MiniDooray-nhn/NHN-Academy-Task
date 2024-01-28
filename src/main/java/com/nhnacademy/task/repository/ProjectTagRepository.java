package com.nhnacademy.task.repository;

import com.nhnacademy.task.domain.ProjectTag;
import com.nhnacademy.task.dto.project.tag.ProjectTagResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectTagRepository extends JpaRepository<ProjectTag, Long> {


    List<ProjectTagResponse> findAllByProjectId(Long projectId);

    ProjectTagResponse queryById(Long projectTagId);

    Optional<ProjectTag> findByProjectId(Long projectId);


}
