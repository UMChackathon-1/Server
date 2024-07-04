package com.PartyTonight.PartyTonight.domain.albeitcomment.service;

import com.PartyTonight.PartyTonight.domain.albeitboard.entity.AlbeitBoard;
import com.PartyTonight.PartyTonight.domain.albeitboard.repository.AlbeitBoardRepository;
import com.PartyTonight.PartyTonight.domain.albeitcomment.dto.request.AlbeitCommentRequest;
import com.PartyTonight.PartyTonight.domain.albeitcomment.entity.AlbeitComment;
import com.PartyTonight.PartyTonight.domain.albeitcomment.repository.AlbeitCommentRepository;
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
public class AlbeitCommentService {

    private final AuthService authService;
    private final AlbeitCommentRepository albeitCommentRepository;
    private final AlbeitBoardRepository albeitBoardRepository;

    @Transactional
    public void createAlbeitComment(AlbeitCommentRequest request) {
        Member member = authService.getLoginUser();
        albeitCommentRepository.save(AlbeitComment.builder()
                .content(request.getContent())
                .member(member)
                .build()
        );
    }

    public List<AlbeitComment> getAlbeitComments(Long boardId) {
        return albeitCommentRepository.findAllByAlbeitBoardId(boardId);
    }


}
