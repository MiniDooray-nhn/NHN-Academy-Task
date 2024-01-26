package com.nhnacademy.task.exception;

public class ProjectMilestoneIsNotExistException extends RuntimeException{
    public ProjectMilestoneIsNotExistException() {
        super("존재하지 않는 프로젝트-마일스톤 입니다");
    }
}
