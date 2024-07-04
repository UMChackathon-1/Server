package com.PartyTonight.PartyTonight.domain.member.api;

import com.PartyTonight.PartyTonight.domain.member.dto.response.ProfileResponse;
import com.PartyTonight.PartyTonight.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/profile")
    public ProfileResponse getProfile() {
        return memberService.getProfile();
    }
}
