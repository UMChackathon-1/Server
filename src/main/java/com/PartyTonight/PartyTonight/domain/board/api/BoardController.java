package com.PartyTonight.PartyTonight.domain.board.api;

import com.PartyTonight.PartyTonight.domain.board.dto.request.BoardRequest;
import com.PartyTonight.PartyTonight.domain.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createBoard(@Valid @RequestBody BoardRequest request) {
        boardService.createBoard(request);
    }

}
