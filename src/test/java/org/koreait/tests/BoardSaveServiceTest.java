package org.koreait.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.koreait.controllers.BoardDataForm;
import org.koreait.models.board.BoardValidationException;
import org.koreait.models.board.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("게시글 저장 테스트")
public class BoardSaveServiceTest {

    @Autowired
    private SaveService saveService;

    private BoardDataForm boardData;

    @BeforeEach
    void init() {
        boardData= getData();
    }

    private BoardDataForm getData(){
        BoardDataForm boardData = new BoardDataForm();
        boardData.setPoster("작성자");
        boardData.setSubject("제목");
        boardData.setContent("내용");

        return boardData;
    }

    @Test @DisplayName("게시글 수작성 성공시 예외 X")
    void saveSuccessTest() {
        assertDoesNotThrow(()-> {
            saveService.save(boardData);
        });
    }
    @Test
    @DisplayName("필수항목 검증, 검증 실패시 BoardValidationException")
    void requiredFieldsTest() {
        assertAll(
                () -> {
                    //poster = null
                  boardData= getData();
                  boardData.setPoster(null);
                  requiredFieldTestEach(boardData,"작성자");
                },
                () -> {
                    //poster = 빈 값
                    boardData= getData();
                    boardData.setPoster("   ");
                    requiredFieldTestEach(boardData,"작성자");
                },
                () -> {
                    //subject = null
                    boardData= getData();
                    boardData.setSubject(null);
                    requiredFieldTestEach(boardData,"제목");
                },
                () -> {
                    //subject = 빈 값
                    boardData= getData();
                    boardData.setSubject("   ");
                    requiredFieldTestEach(boardData,"제목");
                },
                () -> {
                    //content = null
                    boardData= getData();
                    boardData.setContent(null);
                    requiredFieldTestEach(boardData,"내용");
                },
                () -> {
                    //content = 빈 값
                    boardData= getData();
                    boardData.setContent("   ");
                    requiredFieldTestEach(boardData,"내용");
                }


                );

    }

    private void requiredFieldTestEach(BoardDataForm data,String message) {
        BoardValidationException thrown = assertThrows(BoardValidationException.class, () -> {
            saveService.save(data);
        });
    }

}
