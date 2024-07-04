package com.PartyTonight.PartyTonight.domain.albeitboard.service;

import com.PartyTonight.PartyTonight.domain.albeitboard.dto.request.AlbeitBoardRequest;
import com.PartyTonight.PartyTonight.domain.albeitboard.dto.response.AlbeitBoardDetailResponse;
import com.PartyTonight.PartyTonight.domain.albeitboard.dto.response.AlbeitBoardPreviewResponse;
import com.PartyTonight.PartyTonight.domain.albeitboard.entity.AlbeitBoard;
import com.PartyTonight.PartyTonight.domain.albeitboard.repository.AlbeitBoardRepository;
import com.PartyTonight.PartyTonight.domain.albeitcomment.entity.AlbeitComment;
import com.PartyTonight.PartyTonight.domain.albeitcomment.repository.AlbeitCommentRepository;
import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import com.PartyTonight.PartyTonight.domain.freecomment.repository.FreeCommentRepository;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
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
public class AlbeitBoardService {

    private final AlbeitBoardRepository albeitBoardRepository;
    private final AuthService authService;
    private final AlbeitCommentRepository albeitCommentRepository;

    @Transactional
    public void createAlbeitBoard(AlbeitBoardRequest request) {
        Member member = authService.getLoginUser();
        albeitBoardRepository.save(AlbeitBoard.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .member(member)
                .build()
        );
    }

    public List<AlbeitBoardPreviewResponse> getAllAlbeitBoards() {
        Member member = authService.getLoginUser();
        List<AlbeitBoard> boards = albeitBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<AlbeitBoardPreviewResponse> responses = new ArrayList<>();

        boards.forEach(board -> responses.add(AlbeitBoardPreviewResponse.builder()
                .boardId(board.getId())
                .memberId(member.getId())
                .title(board.getTitle())
                .views(board.getViews())
                .createdAt(board.getCreatedAt())
                .build()
        ));
        return responses;
    }

    public List<AlbeitBoardPreviewResponse> getAlbeitBoardsOrderedByViews() {
        Member member = authService.getLoginUser();
        List<AlbeitBoard> albeitBoards = albeitBoardRepository.findAll(Sort.by(Sort.Direction.DESC, "Views"));
        List<AlbeitBoardPreviewResponse> responses = new ArrayList<>();

        albeitBoards.forEach(board -> responses.add(AlbeitBoardPreviewResponse.builder()
                .boardId(board.getId())
                .memberId(member.getId())
                .title(board.getTitle())
                .views(board.getViews())
                .createdAt(board.getCreatedAt())
                .build()
        ));
        return responses;
    }

    @Transactional
    public AlbeitBoardDetailResponse getAlbeitBoard(Long id) {
        Member member = authService.getLoginUser();
        List<AlbeitComment> albeitComments = albeitCommentRepository.findAllByAlbeitBoardId(id);
        AlbeitBoard albeitboard = albeitBoardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        albeitboard.increaseViews();

        return AlbeitBoardDetailResponse.builder()
                .title(albeitboard.getTitle())
                .content(albeitboard.getContent())
                .views(albeitboard.getViews())
                .memberId(member.getId())
                .albeitComments(albeitComments)
                .createdAt(albeitboard.getCreatedAt())
                .build();
    }


}
