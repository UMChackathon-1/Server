package com.PartyTonight.PartyTonight.domain.board.api;

import com.PartyTonight.PartyTonight.domain.board.dto.request.BoardRequest;
import com.PartyTonight.PartyTonight.domain.board.dto.response.BoardResponse;
import com.PartyTonight.PartyTonight.domain.board.entity.Board;
import com.PartyTonight.PartyTonight.domain.board.service.BoardService;
import com.PartyTonight.PartyTonight.domain.comment.entity.Comment;
import com.PartyTonight.PartyTonight.domain.comment.service.CommentService;
import com.PartyTonight.PartyTonight.domain.picture.dto.response.PicturePreviewResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;
    private final CommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createBoard(@Valid @RequestBody BoardRequest request) {
        boardService.createBoard(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{boardId}")
    public List<Comment> getCommentsByBoardId(@PathVariable Long boardId) {
        return commentService.getCommentsByBoardId(boardId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<BoardResponse> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("sorted-by-viewcount")
    public List<BoardResponse> getBoardsByViewsDesc() {
        return boardService.getBoardsOrderedByViews();
    }

}
