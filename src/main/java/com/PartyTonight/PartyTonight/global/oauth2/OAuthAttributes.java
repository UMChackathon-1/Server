package com.PartyTonight.PartyTonight.global.oauth2;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.entity.Role;
import com.PartyTonight.PartyTonight.domain.member.entity.SocialType;
import com.PartyTonight.PartyTonight.domain.member.entity.Status;
import com.PartyTonight.PartyTonight.global.oauth2.userInfo.KakaoOAuth2UserInfo;
import com.PartyTonight.PartyTonight.global.oauth2.userInfo.OAuth2UserInfo;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private final String nameAttributeKey;
    private final OAuth2UserInfo oauth2UserInfo;

    @Builder
    private OAuthAttributes(String nameAttributeKey, OAuth2UserInfo oauth2UserInfo) {
        this.nameAttributeKey = nameAttributeKey;
        this.oauth2UserInfo = oauth2UserInfo;
    }

    public static OAuthAttributes of(SocialType socialType,
                                     String userNameAttributeName, Map<String, Object> attributes) {
        return ofKakao(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .nameAttributeKey(userNameAttributeName)
                .oauth2UserInfo(new KakaoOAuth2UserInfo(attributes))
                .build();
    }

    public Member toEntity(SocialType socialType, OAuth2UserInfo oauth2UserInfo) {
        return Member.builder()
                .socialType(socialType)
                .oauthId(oauth2UserInfo.getId())
                .email(oauth2UserInfo.getEmail())
                .nickname(oauth2UserInfo.getNickname())
                .imageUrl(oauth2UserInfo.getImageUrl())
                .role(Role.GUEST)
                .status(Status.ACTIVE)
                .build();
    }
}

