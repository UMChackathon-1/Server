package com.PartyTonight.PartyTonight.domain.freeboard.service;

import com.PartyTonight.PartyTonight.domain.freeboard.dto.request.FreeBoardRequest;
import com.PartyTonight.PartyTonight.domain.freeboard.dto.response.FreeBoardDetailResponse;
import com.PartyTonight.PartyTonight.domain.freeboard.dto.response.FreeBoardPreviewResponse;
import com.PartyTonight.PartyTonight.domain.freeboard.entity.FreeBoard;
import com.PartyTonight.PartyTonight.domain.freeboard.repository.FreeBoardRepository;
import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import com.PartyTonight.PartyTonight.domain.freecomment.repository.FreeCommentRepository;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.repository.MemberRepository;
import com.PartyTonight.PartyTonight.domain.member.service.AuthService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;
    private final AuthService authService;
    private final FreeCommentRepository freeCommentRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void createFreeBoard(FreeBoardRequest request) {
        Member member = authService.getLoginUser();
        freeBoardRepository.save(FreeBoard.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(member)
                .build()
        );
    }

    public List<FreeBoardPreviewResponse> getAllFreeBoards() {
        List<FreeBoard> boards = freeBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<FreeBoardPreviewResponse> responses = new ArrayList<>();

        boards.forEach(board -> responses.add(FreeBoardPreviewResponse.builder()
                .boardId(board.getId())
                .memberId(board.getMember().getId())
                .title(board.getTitle())
                .views(board.getViews())
                .createdAt(board.getCreatedAt())
                .build()
        ));
        return responses;
    }

    public List<FreeBoardPreviewResponse> getFreeBoardsOrderedByViews() {
        List<FreeBoard> freeboards = freeBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "Views"));
        List<FreeBoardPreviewResponse> responses = new ArrayList<>();

        freeboards.forEach(board -> responses.add(FreeBoardPreviewResponse.builder()
                .boardId(board.getId())
                .memberId(board.getMember().getId())
                .title(board.getTitle())
                .views(board.getViews())
                .createdAt(board.getCreatedAt())
                .build()
        ));
        return responses;
    }

    @Transactional
    public FreeBoardDetailResponse getFreeBoard(Long id) {
        List<FreeComment> freeComments = freeCommentRepository.findAllByFreeBoardId(id);
        FreeBoard freeboard = freeBoardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        freeboard.increaseViews();

        return FreeBoardDetailResponse.builder()
                .title(freeboard.getTitle())
                .content(freeboard.getContent())
                .views(freeboard.getViews())
                .memberId(freeboard.getMember().getId())
                .freeComments(freeComments)
                .createdAt(freeboard.getCreatedAt())
                .build();
    }


}
