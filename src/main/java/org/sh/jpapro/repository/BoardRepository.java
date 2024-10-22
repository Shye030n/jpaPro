package org.sh.jpapro.repository;

import org.sh.jpapro.domain.Board;
import org.sh.jpapro.repository.search.BoardSearch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    // Repository 란?,  영어로, 저장소.
    // 코딩에서는 "데이터에 접근 및 관라하는 클래스. => DB에 있는 데이터를 저장 및 조회하는 클래스)

    //BoardRepository 클래스는, board라는 Entity의 저장소
    //BoardRepository 클래스는, JpaRepository 클래스를 상속받음.
    //Entity란 DB에서 table과 mapping되는 객체.

    //@Query("select b from Board b where b.title like concat('%',:keyword,'%') order by b.bno desc")
        //파라미터에 BoardSearch 추가해서 주석처리

    Page<Board> searchAll(String keyword,Pageable pageable);
        // concat이 문자열을 결합하라


    //Page<Board> findByTitle(String title, Pageable pageable);
    // = select * from board where title=? (board 테이블에서 제목이 ?인 것을 모두 선택)이 쿼리문과 동일
}
