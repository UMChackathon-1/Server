package com.PartyTonight.PartyTonight.domain.board.service;

import com.PartyTonight.PartyTonight.domain.board.dto.request.BoardRequest;
import com.PartyTonight.PartyTonight.domain.board.dto.response.BoardResponse;
import com.PartyTonight.PartyTonight.domain.board.entity.Board;
import com.PartyTonight.PartyTonight.domain.board.repository.BoardRepository;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final AuthService authService;

    @Transactional
    public void createBoard(BoardRequest request) {
        boardRepository.save(Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build()
        );
    }

    public List<BoardResponse> getAllBoards() {
        Member member = authService.getLoginUser();
        List<Board> boards = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        List<BoardResponse> responses = new ArrayList<>();

        boards.forEach(board -> responses.add(BoardResponse.builder()
                .boardId(board.getId())
                .memberId(member.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .views(board.getViews())
                .createdAt(board.getCreatedAt())
                .boardType(board.getBoardType())
                .build()
        ));
        return responses;
    }

    public List<BoardResponse> getBoardsOrderedByViews() {
        Member member = authService.getLoginUser();
        List<Board> boards = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "Views"));
        List<BoardResponse> responses = new ArrayList<>();

        boards.forEach(board -> responses.add(BoardResponse.builder()
                .boardId(board.getId())
                .memberId(member.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .views(board.getViews())
                .createdAt(board.getCreatedAt())
                .boardType(board.getBoardType())
                .build()
        ));
        return responses;
    }


}
