package com.nhnacademy.task.domain;

import java.time.LocalDateTime;
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

@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "task_title")
    private String title;
    @Column(name = "task_content")
    private String contents;
    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}