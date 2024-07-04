package com.PartyTonight.PartyTonight.domain.albeitboard.dto.response;

import com.PartyTonight.PartyTonight.domain.albeitcomment.entity.AlbeitComment;
import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlbeitBoardDetailResponse {

    private Long boardId;
    private Long memberId;
    private Integer views;
    private String title;
    private String content;
    private List<AlbeitComment> albeitComments;
    private LocalDateTime createdAt;

}
