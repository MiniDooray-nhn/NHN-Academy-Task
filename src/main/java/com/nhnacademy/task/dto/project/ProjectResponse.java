package com.nhnacademy.task.dto.project;

import java.time.LocalDate;

public interface ProjectGetResponse {

    Long getId();

    String getTitle();

    String getProjectStatusName();
    LocalDate getCreatedAt();

}
