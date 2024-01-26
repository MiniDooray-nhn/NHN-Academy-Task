package com.nhnacademy.task.domain;

import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.ProjectRegisterAndModifyResponse;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "admin_id")
    private String userId;

    @ManyToOne
    @JoinColumn(name = "project_status_id")
    private ProjectStatus projectStatus;

    @Column(name = "project_title")
    private String title;

    @Column(name = "createdAt")
    private LocalDate createdAt;


    public ProjectRegisterAndModifyResponse converToDto() {
        return new ProjectRegisterAndModifyResponse(this.userId, this.projectStatus.getId(), this.title);
    }

    public void setProjectByRegisterRequest(ProjectRegisterAndModifyRequest registerRequest,
                                            ProjectStatus projectStatus) {

        this.userId = registerRequest.getUserId();
        this.title = registerRequest.getTitle();
        this.projectStatus = projectStatus;
        this.createdAt = LocalDate.now();
    }

    public void setProjectByModifyRequest(ProjectRegisterAndModifyRequest registerRequest,
                                          ProjectStatus projectStatus) {

        this.userId = registerRequest.getUserId();
        this.title = registerRequest.getTitle();
        this.projectStatus = projectStatus;

    }

}
