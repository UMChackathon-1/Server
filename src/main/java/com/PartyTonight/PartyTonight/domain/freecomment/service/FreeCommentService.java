package com.PartyTonight.PartyTonight.domain.freecomment.service;

import com.PartyTonight.PartyTonight.domain.freeboard.entity.FreeBoard;
import com.PartyTonight.PartyTonight.domain.freeboard.repository.FreeBoardRepository;
import com.PartyTonight.PartyTonight.domain.freecomment.dto.request.FreeCommentRequest;
import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import com.PartyTonight.PartyTonight.domain.freecomment.repository.FreeCommentRepository;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.service.AuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeCommentService {

    private final AuthService authService;
    private final FreeCommentRepository freeCommentRepository;
    private final FreeBoardRepository freeBoardRepository;

    @Transactional
    public void createFreeComment(FreeCommentRequest request) {
        Member member = authService.getLoginUser();
        freeCommentRepository.save(FreeComment.builder()
                .content(request.getContent())
                .member(member)
                .build()
        );
    }

    public List<FreeComment> getFreeComments(Long boardId) {
        FreeBoard freeboard = freeBoardRepository.findById(boardId).orElseThrow(EntityNotFoundException::new);
        return freeCommentRepository.findAllByFreeBoardId(boardId);
    }


}
