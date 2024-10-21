package org.sh.jpapro.service;

import lombok.extern.log4j.Log4j2;
import org.sh.jpapro.domain.Board;
import org.sh.jpapro.dto.PageRequestDTO;
import org.sh.jpapro.dto.PageResponseDTO;
import org.sh.jpapro.repository.BoardRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    //BoardService 클래스를 구체화 하는 클래스


    @Override
    public PageResponseDTO<Board> getList(PageRequestDTO pageRequestDTO) {
        log.info("getList");
        Pageable pageable=pageRequestDTO.getPageable("bno");
        List<Board> boardList = boardRepository.findAll();
        log.info("getList");
        return boardList;
    }

    @Override
    public Board getBoard(Long bno) {
        log.info("getBoard"+bno);
        return boardRepository.findById(bno).get();
    }

    @Override
    public void saveBoard(Board board) {
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        log.info("update board"+board);
        Board oldBoard = boardRepository.findById(board.getBno()).get();
        oldBoard.setTitle(board.getTitle());
        oldBoard.setContent(board.getContent());
        oldBoard.setWriter(board.getWriter());
        boardRepository.save(oldBoard);

    }

    @Override
    public void deleteBoard(Long bno) {
        log.info("Delete Board"+bno);
        boardRepository.deleteById(bno);
    }
}
