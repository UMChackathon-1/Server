package com.PartyTonight.PartyTonight.domain.member.service;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.repository.MemberRepository;
import com.PartyTonight.PartyTonight.global.jwt.service.JwtService;
import com.PartyTonight.PartyTonight.global.query.QueryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
@QueryService
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;


    @Value("${oauth.kakao.admin-key}")
    private String kakaoAdminKey;

    @Value("${oauth.kakao.withdraw-uri}")
    private String kakaoWithdrawUri;

    public Long getLoginUserId() {
        return getLoginUser().getId();
    }

    public Member getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return memberRepository.findByEmail(userDetails.getUsername()).orElseThrow(EntityNotFoundException::new);
    }

}

