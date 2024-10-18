package org.sh.jpapro.repository;

import org.sh.jpapro.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
