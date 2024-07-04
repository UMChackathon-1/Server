package com.PartyTonight.PartyTonight.domain.picture.api;

import com.PartyTonight.PartyTonight.domain.picture.dto.request.PictureRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Picture")
public interface PictureApi {
    @Operation(
            summary = "사진 등록",
            description = "사진을 등록합니다.",
            security = {@SecurityRequirement(name = "access_token")}
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "사진이 성공적으로 등록되었습니다."
            )
    })
    void createPicture(PictureRequest request);

}
