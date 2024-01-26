package com.nhnacademy.task.dto.project;

import java.time.LocalDate;

public interface ProjectResponse {

    Long getId();

    String getTitle();

    String getProjectStatusName();
    LocalDate getCreatedAt();

}
