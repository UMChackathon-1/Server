package com.PartyTonight.PartyTonight.domain.board.dto.response;

import com.PartyTonight.PartyTonight.domain.board.entity.BoardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {

    private Long boardId;
    private Long memberId;
    private Integer views;
    private String title;
    private String content;
    private BoardType boardType;
    private LocalDateTime createdAt;

}
