package com.PartyTonight.PartyTonight.domain.member.service;

import com.PartyTonight.PartyTonight.domain.member.dto.SignUpRequest;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.repository.MemberRepository;
import com.PartyTonight.PartyTonight.global.jwt.refresh.service.RefreshTokenService;
import com.PartyTonight.PartyTonight.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SignUpService {
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;
    private final HttpServletResponse response;
    private final MemberRepository memberRepository;

    @Transactional
    public boolean signUp(SignUpRequest request) {
        if (memberRepository.existsByNickname(request.getNickname())) {
            return false;
        }
        Member member = authService.getLoginUser();
        member.signUp(request);
        String refreshToken = jwtService.createRefreshToken();
        jwtService.setRefreshTokenHeader(response, refreshToken);
        refreshTokenService.updateToken(member.getEmail(), refreshToken);
        return true;
    }
}
