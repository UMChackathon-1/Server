package com.PartyTonight.PartyTonight.domain.freeboard.repository;

import com.PartyTonight.PartyTonight.domain.freeboard.entity.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {
}
