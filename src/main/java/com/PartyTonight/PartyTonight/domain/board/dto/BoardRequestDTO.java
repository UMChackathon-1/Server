package com.PartyTonight.PartyTonight.domain.board.dto;

import lombok.Getter;
import lombok.Setter;

public class BoardRequestDTO {

    @Getter
    public static class PostDto {
        private String title;
        private String content;
    }
}
