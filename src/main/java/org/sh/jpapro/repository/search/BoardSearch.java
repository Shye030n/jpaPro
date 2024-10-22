package org.sh.jpapro.repository.search;

import org.sh.jpapro.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page<Board> searchAll(String[] types, String keyword, Pageable pageable);
        // 추상 메서드 만듦 -> 이체 추상 메서드를 구현하는 클래스를 만들거야(BoardSearchImpl)
}
