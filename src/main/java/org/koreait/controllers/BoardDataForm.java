package org.koreait.controllers;

import lombok.Data;

@Data
public class BoardDataForm {
    private long id;
    private String poster;
    private String subject;
    private String content;

}
