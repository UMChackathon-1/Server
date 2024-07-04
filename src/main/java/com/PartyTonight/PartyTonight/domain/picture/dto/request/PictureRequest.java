package com.PartyTonight.PartyTonight.domain.picture.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PictureRequest {
    @Schema(description = "사진 URL입니다. 공백으로 제출 불가능해용.'")
    @NotBlank
    private String url;

    private String title;
}
