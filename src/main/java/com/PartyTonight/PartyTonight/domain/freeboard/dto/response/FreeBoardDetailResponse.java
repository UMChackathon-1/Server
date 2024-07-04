package com.PartyTonight.PartyTonight.domain.freeboard.dto.response;

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
public class FreeBoardDetailResponse {

    private Long boardId;
    private Long memberId;
    private Integer views;
    private String title;
    private String content;
    private List<FreeComment> freeComments;
    private LocalDateTime createdAt;

}
