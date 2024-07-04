package com.PartyTonight.PartyTonight.domain.freeboard.api;

import com.PartyTonight.PartyTonight.domain.freeboard.dto.request.FreeBoardRequest;
import com.PartyTonight.PartyTonight.domain.freeboard.dto.response.FreeBoardPreviewResponse;
import com.PartyTonight.PartyTonight.domain.freeboard.service.FreeBoardService;
import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import com.PartyTonight.PartyTonight.domain.freecomment.service.FreeCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("freeboards")
public class FreeBoardController {
    private final FreeBoardService freeBoardService;
    private final FreeCommentService freeCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createFreeBoard(@Valid @RequestBody FreeBoardRequest request) {
        freeBoardService.createFreeBoard(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{freeboardId}/comments")
    public List<FreeComment> getCommentsByFreeBoardId(@PathVariable Long freeboardId) {
        return freeCommentService.getFreeComments(freeboardId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all")
    public List<FreeBoardPreviewResponse> getAllFreeBoards() {
        return freeBoardService.getAllFreeBoards();
    }

    @GetMapping("/sorted-by-views")
    public List<FreeBoardPreviewResponse> getFreeBoardsByViewsDesc() {
        return freeBoardService.getFreeBoardsOrderedByViews();
    }

}
