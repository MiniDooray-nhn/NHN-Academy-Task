package com.nhnacademy.task.exception;

public class ProjectStatusIsNotExistException extends RuntimeException{
    public ProjectStatusIsNotExistException() {
        super("프로젝트 상태가 존재하지 않습니다");
    }
}
