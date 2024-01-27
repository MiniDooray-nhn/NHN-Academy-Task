package com.nhnacademy.task.domain;

import com.nhnacademy.task.dto.project.member.ProjectMemberRegisterResponse;
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
@Table(name = "project_member")
@Entity
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_member_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "user_id")
    private String userId;


    public ProjectMemberRegisterResponse covertToDto() {

        ProjectMemberRegisterResponse projectMemberRegisterResponse = new ProjectMemberRegisterResponse();
        projectMemberRegisterResponse.setUserId(this.userId);
        return projectMemberRegisterResponse;
    }

}
