package com.nhnacademy.task.exception;

public class TagIsNotExistException extends RuntimeException{
    public TagIsNotExistException() {
        super("존재하지 않는 태그입니다");
    }
}
