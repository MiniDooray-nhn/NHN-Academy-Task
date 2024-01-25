package com.nhnacademy.task.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
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


}
