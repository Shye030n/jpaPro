package org.sh.jpapro.service;

import org.sh.jpapro.domain.Board;
import org.sh.jpapro.dto.BoardDTO;
import org.sh.jpapro.dto.PageRequestDTO;
import org.sh.jpapro.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    Board getBoard(Long bno);
    void saveBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Long bno);
}
