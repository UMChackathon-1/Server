package com.PartyTonight.PartyTonight.domain.albeitboard.api;

import com.PartyTonight.PartyTonight.domain.albeitboard.dto.request.AlbeitBoardRequest;
import com.PartyTonight.PartyTonight.domain.albeitboard.dto.response.AlbeitBoardPreviewResponse;
import com.PartyTonight.PartyTonight.domain.albeitboard.service.AlbeitBoardService;
import com.PartyTonight.PartyTonight.domain.albeitcomment.entity.AlbeitComment;
import com.PartyTonight.PartyTonight.domain.albeitcomment.service.AlbeitCommentService;
import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import com.PartyTonight.PartyTonight.domain.freecomment.service.FreeCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("albeitboards")
public class AlbeitBoardController {
    private final AlbeitBoardService albeitBoardService;
    private final AlbeitCommentService albeitCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createAlbeitBoard(@Valid @RequestBody AlbeitBoardRequest request) {
        albeitBoardService.createAlbeitBoard(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{albeitboardId}/comments")
    public List<AlbeitComment> getCommentsByAlbeitBoardId(@PathVariable Long albeitboardId) {
        return albeitCommentService.getAlbeitComments(albeitboardId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<AlbeitBoardPreviewResponse> getAllAlbeitBoards() {
        return albeitBoardService.getAllAlbeitBoards();
    }

    @GetMapping("/sorted-by-views")
    public List<AlbeitBoardPreviewResponse> getAlbeitBoardsByViewsDesc() {
        return albeitBoardService.getAlbeitBoardsOrderedByViews();
    }

}
