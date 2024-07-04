package com.PartyTonight.PartyTonight.domain.picture.dto.response;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PicturePreviewResponse {
    @Schema(description = "사진 ID")
    private Long id;

    @Schema(description = "사진 URL")
    private String url;

    @Schema(description = "좋아요 수")
    private Integer likeNum;

    @Schema(description = "제목")
    private String title;
}
