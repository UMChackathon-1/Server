package com.PartyTonight.PartyTonight.domain.albeitcomment.api;

import com.PartyTonight.PartyTonight.domain.albeitcomment.dto.request.AlbeitCommentRequest;
import com.PartyTonight.PartyTonight.domain.albeitcomment.service.AlbeitCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("albeitcomments")
public class AlbeitCommentController {
    private final AlbeitCommentService albeitCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createAlbeitComment(@Valid @RequestBody AlbeitCommentRequest request) {
        albeitCommentService.createAlbeitComment(request);
    }
}
