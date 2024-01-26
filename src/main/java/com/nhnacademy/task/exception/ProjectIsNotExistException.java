package com.nhnacademy.task.exception;

public class ProjectIsNotExistException extends RuntimeException{
    public ProjectIsNotExistException() {
        super("존재하지않는 프로젝트입니다");
    }
}
