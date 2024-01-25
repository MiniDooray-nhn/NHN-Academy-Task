package com.nhnacademy.task.dto.project;

import com.nhnacademy.task.domain.ProjectStatus;
import java.time.LocalDate;

public interface ProjectResponse {


    Long getProjectId();

    String getTitle();

    String getProjectStatusName();
    LocalDate getCreatedAt();

}
