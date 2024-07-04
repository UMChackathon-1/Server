package com.PartyTonight.PartyTonight.domain.board.service;

import com.PartyTonight.PartyTonight.domain.board.dto.request.BoardRequest;
import com.PartyTonight.PartyTonight.domain.board.entity.Board;
import com.PartyTonight.PartyTonight.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void createBoard(BoardRequest request) {
        boardRepository.save(Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build()
        );
    }
}
