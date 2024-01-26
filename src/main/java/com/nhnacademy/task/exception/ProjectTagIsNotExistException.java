package com.nhnacademy.task.exception;

public class ProjectTagIsNotExistException extends RuntimeException{
    public ProjectTagIsNotExistException() {
        super("존재하지않는 프로젝트-태그입니다");
    }
}
