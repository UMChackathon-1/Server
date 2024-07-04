package com.PartyTonight.PartyTonight.domain.freecomment.api;

import com.PartyTonight.PartyTonight.domain.freecomment.dto.request.FreeCommentRequest;
import com.PartyTonight.PartyTonight.domain.freecomment.service.FreeCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("freecomments")
public class FreeCommentController {
    private final FreeCommentService freeCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createFreeComment(@Valid @RequestBody FreeCommentRequest request) {
        freeCommentService.createFreeComment(request);
    }
}
