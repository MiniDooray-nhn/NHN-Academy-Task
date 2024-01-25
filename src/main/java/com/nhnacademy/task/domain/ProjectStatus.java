package com.nhnacademy.task.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="project_status")
public class ProjectStatus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_status_id")
    private Integer id;

    @Column(name="project_status_name")
    private String name;

}
