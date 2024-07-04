package com.PartyTonight.PartyTonight.domain.freeboard.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FreeBoardPreviewResponse {

    private Long boardId;
    private Long memberId;
    private Integer views;
    private String title;
    private LocalDateTime createdAt;

}
