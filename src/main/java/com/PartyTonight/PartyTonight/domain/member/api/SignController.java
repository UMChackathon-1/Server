package com.PartyTonight.PartyTonight.domain.member.api;

import com.PartyTonight.PartyTonight.domain.member.dto.SignUpRequest;
import com.PartyTonight.PartyTonight.domain.member.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {
    private final SignUpService signUpService;

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/oauth2/sign-up")
    public boolean signUp(@RequestBody SignUpRequest request) {
        return signUpService.signUp(request);
    }
}
