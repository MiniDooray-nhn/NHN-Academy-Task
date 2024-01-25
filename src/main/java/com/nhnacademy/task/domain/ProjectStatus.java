package com.nhnacademy.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_status_id")
    private Integer id;

    @Column(name="project_status_name")
    private String name;

}
