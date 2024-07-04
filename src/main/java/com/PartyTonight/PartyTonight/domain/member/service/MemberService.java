package com.PartyTonight.PartyTonight.domain.member.service;

import com.PartyTonight.PartyTonight.domain.member.dto.response.ProfileResponse;
import com.PartyTonight.PartyTonight.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public ProfileResponse getProfile() {
        return ProfileResponse.builder()
                .imageUrl("http://t1.kakaocdn.net/account_images/default_profile.jpeg.twg.thumb.R640x640")
                .nickname("이면지")
                .build();
    }
}
