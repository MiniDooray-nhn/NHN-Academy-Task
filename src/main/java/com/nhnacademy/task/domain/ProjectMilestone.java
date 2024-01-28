package com.nhnacademy.task.domain;

import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyRequest;
import com.nhnacademy.task.dto.project.milestone.ProjectMileStoneRegisterAndModifyResponse;
import javax.persistence.CascadeType;
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

@Entity
@Getter
@Setter
@Table(name = "project_milestone")
public class ProjectMilestone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_milestone_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "project_milestone_name")
    private String name;


    public void setProjectMileStoneByRegisterRequest(Project project,
                                                     ProjectMileStoneRegisterAndModifyRequest registerRequest) {

        this.project = project;
        this.name = registerRequest.getName();
    }

    public void setProjectMileStoneByModifyRequest(ProjectMileStoneRegisterAndModifyRequest modifyRequest) {
        this.name = modifyRequest.getName();
    }


    public ProjectMileStoneRegisterAndModifyResponse convertToDto() {
        return new ProjectMileStoneRegisterAndModifyResponse(this.name);
    }


}
