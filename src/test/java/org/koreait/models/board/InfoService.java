package org.koreait.models.board;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class InfoService {
    private final BoardDataDao boardDataDao;
    public BoardData get(long id) {
        return boardDataDao.get(id);
    }
}
