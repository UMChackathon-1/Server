package com.PartyTonight.PartyTonight.domain.board.dto;

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
    Long boardId;
    LocalDateTime createdAt;
}
