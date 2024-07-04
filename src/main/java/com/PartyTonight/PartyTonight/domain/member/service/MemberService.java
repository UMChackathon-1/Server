package com.PartyTonight.PartyTonight.domain.member.service;

import com.PartyTonight.PartyTonight.domain.member.dto.response.ProfileResponse;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.repository.MemberRepository;
import com.PartyTonight.PartyTonight.domain.picture.dto.response.PictureDetailResponse;
import com.PartyTonight.PartyTonight.domain.picture.entity.Picture;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final AuthService authService;
    private final MemberRepository memberRepository;

    public ProfileResponse getProfile() {
        Member member = authService.getLoginUser();
        return ProfileResponse.builder()
                .imageUrl(member.getImageUrl())
                .nickname(member.getNickname())
                .build();
    }
}
