package com.PartyTonight.PartyTonight.domain.board.repository;

import com.PartyTonight.PartyTonight.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Long> {

}
