package com.PartyTonight.PartyTonight.domain.picture.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PictureResponse {
    @Schema(description = "사진 ID")
    private Long id;

    @Schema(description = "사진 URL")
    private String url;
}
