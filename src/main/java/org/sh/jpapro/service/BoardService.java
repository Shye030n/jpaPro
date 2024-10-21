package org.sh.jpapro.service;

import org.sh.jpapro.domain.Board;
import org.sh.jpapro.dto.PageResponseDTO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BoardService {
    PageResponseDTO<Board> getList(PageRequest pageRequestDTO);
    Board getBoard(Long bno);
    void saveBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Long bno);
}
