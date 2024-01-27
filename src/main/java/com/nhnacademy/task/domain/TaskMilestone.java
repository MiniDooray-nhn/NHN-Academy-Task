package com.nhnacademy.task.domain;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="task_milestone")
@RequiredArgsConstructor
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
