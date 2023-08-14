package org.koreait.models;

public class BoardValidationException extends RuntimeException{
    public BoardValidationException(String message) {
        super(message);
    }
}
