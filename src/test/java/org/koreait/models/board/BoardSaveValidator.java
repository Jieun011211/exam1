package org.koreait.models.board;

import org.koreait.controllers.BoardDataForm;
import org.koreait.models.board.BoardValidationException;
import org.koreait.validators.RequiredValidator;
import org.koreait.validators.Validator;

public class BoardSaveValidator implements Validator<BoardDataForm>, RequiredValidator {

    public void check(BoardDataForm data) {
        checkRequired(data.getPoster(), new BoardValidationException("작성자 입력"));
        checkRequired(data.getSubject(), new BoardValidationException("제목 입력"));
        checkRequired(data.getContent(), new BoardValidationException("내용 입력"));

    }
}
