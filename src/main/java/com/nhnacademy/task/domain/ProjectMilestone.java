package com.nhnacademy.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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


}
