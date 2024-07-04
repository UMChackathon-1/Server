package com.PartyTonight.PartyTonight.domain.picture.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PictureDetailResponse {
    @Schema(description = "사진 ID")
    private Long id;

    @Schema(description = "사진 URL")
    private String url;

    @Schema(description = "제목")
    private String title;

    @Schema(description = "좋아요 수")
    private Integer likeNum;

    @Schema(description = "싫어요 수")
    private Integer dislikeNum;

    @Schema(description = "다운로드 수")
    private Integer downloadCnt;

    @Schema(description = "작성자 닉네임")
    private String nickname;

    @Schema(description = "사용자가 좋아요 했는지 여부")
    private Boolean isLiked;

    @Schema(description = "사용자가 싫어요 했는지 여부")
    private Boolean isDisliked;
}
