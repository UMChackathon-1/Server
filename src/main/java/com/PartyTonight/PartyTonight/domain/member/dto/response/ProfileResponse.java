package com.PartyTonight.PartyTonight.domain.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProfileResponse {
    private String nickname;
    private String imageUrl;
}
