package com.PartyTonight.PartyTonight.global.oauth2.handler;

import com.PartyTonight.PartyTonight.domain.member.entity.Role;
import com.PartyTonight.PartyTonight.global.jwt.service.JwtService;
import com.PartyTonight.PartyTonight.global.oauth2.CustomOAuth2User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("OAuth2 Login succeed.");
        CustomOAuth2User oAuth2User = (CustomOAuth2User) authentication.getPrincipal();

        if(oAuth2User.getRole() == Role.GUEST) {
            String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
            response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);
            response.sendRedirect("oauth2/sign-up");

            jwtService.sendAccessAndRefreshToken(response, accessToken, null);
        } else {
            loginSuccess(response, oAuth2User);
            response.sendRedirect("/");
        }
    }

    private void loginSuccess(HttpServletResponse response, CustomOAuth2User oAuth2User) throws IOException {
        log.info("회원가입에 성공하였습니다.");

        String accessToken = jwtService.createAccessToken(oAuth2User.getEmail());
        response.addHeader(jwtService.getAccessHeader(), "Bearer " + accessToken);

        jwtService.sendAccessToken(response, accessToken);
    }
}

