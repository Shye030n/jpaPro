package org.sh.jpapro.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.sh.jpapro.domain.Board;
import org.sh.jpapro.dto.BoardDTO;
import org.sh.jpapro.dto.PageRequestDTO;
import org.sh.jpapro.dto.PageResponseDTO;
import org.sh.jpapro.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService { //BoardService 클래스를 구현.  Impl(implementation구현)
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
        log.info("getList");
//        Pageable pageable=pageRequestDTO.getPageable("bno");
//        //이렇게하면 pageable(데이터를 페이지 단위로 나누어 불러옴)이 만들어짐
//
//        //Page<Board> result = boardRepository.findAll(pageable);
//
//        Page<Board> result=null;
//        if(pageRequestDTO.getKeyword()==null || pageRequestDTO.getKeyword().equals("")) {
//             result =boardRepository.findAll(pageable );
//        }
//        else {
//             result = boardRepository.searchAll(pageRequestDTO.getKeyword(), pageable);
//        }
//        log.info("aaaa"+result.getTotalElements());
        String[] types = pageRequestDTO.getTypes();
        String keyword = pageRequestDTO.getKeyword();
        Pageable pageable = pageRequestDTO.getPageable("bno");
        Page<Board> result=boardRepository.searchAll(types, keyword, pageable);
        List<BoardDTO> dtoList=result.getContent().stream()
                .map(board -> modelMapper.map(board, BoardDTO.class))
                .collect(Collectors.toUnmodifiableList());


        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int)result.getTotalElements())
                .build();
    }

    @Override
    public Board getBoard(Long bno) {
        log.info("getBoard"+bno);
        Board board=boardRepository.findById(bno).get();
        board.updateVisitcount();
        boardRepository.save(board);
        return board;
    }

    @Override
    public void saveBoard(Board board) {
        log.info("Saving board: " + board);
        boardRepository.save(board);
    }

    @Override
    public void updateBoard(Board board) {
        log.info("update board"+board);
        Board oldBoard =boardRepository.findById(board.getBno()).get();
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