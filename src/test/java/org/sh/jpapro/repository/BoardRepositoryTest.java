package org.sh.jpapro.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.sh.jpapro.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
        // MySql에 board 테이블 내용을
        // (create)생성, (update)수정, (read)갖고오기,(delete)삭제 하는 클래스. (crud)
    @Test
    public void testInsert() {
        // application.properties 에서 #spring.jpa.hibernate.ddl-auto=create 주석 해제하기 => 태이블 내용 생성
        Board board=new Board();
        board.setTitle("title");
        board.setWriter("user02");
        board.setContent("content1");
        // boardRepository.save(board);

        //application.properties 에서 spring.jpa.hibernate.ddl-auto=update => 테이블 내용 수정
        Board board1=Board.builder()
                .title("title3")
                .content("content3")
                .writer("user03")
                .build();
         boardRepository.save(board1);
    }

    @Test
    public void getListTest(){
        // DB 데이터 목록(list) 갖고오기
        List<Board> list=boardRepository.findAll();
        for(Board board:list){
            log.info(board);
        }
    }

    @Test
    public void getOneTest(){
        // bno=1인 데이터 갖고오기
        Board board = boardRepository.findById(1L).get();
        log.info(board);
    }

    @Test
    public void updateBoardTest(){
        // bno=1 갖고와서 밑에 내용으로 update(수정)하기
        Board board = boardRepository.findById(1L).get();
        board.setTitle("title~");
        board.setContent("content~");
        boardRepository.save(board);
    }

    @Test
    public void deleteBoardTest(){
        // bno=2 delete(삭제)하기
        boardRepository.deleteById(2L);
    }
}
