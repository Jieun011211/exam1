package org.koreait.models;

public class BoardDataNotFoundException extends RuntimeException{
    public BoardDataNotFoundException() {
        super("등록한 게시물이 아님");
    }
}
