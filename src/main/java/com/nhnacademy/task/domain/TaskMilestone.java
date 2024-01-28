package com.nhnacademy.task.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="task_milestone")
public class TaskMilestone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_milestone_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToOne
    @JoinColumn(name = "project_milestone_id")
    private ProjectMilestone projectMilestone;

    public TaskMilestone(Task task, ProjectMilestone projectMilestone) {
        this.task = task;
        this.projectMilestone = projectMilestone;
    }

    public TaskMilestone updateTaskMilestone(Task task, ProjectMilestone projectMilestone) {
        this.task = task;
        this.projectMilestone = projectMilestone;
        return this;
    }

}
