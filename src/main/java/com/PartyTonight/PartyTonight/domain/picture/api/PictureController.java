package com.PartyTonight.PartyTonight.domain.picture.api;

import com.PartyTonight.PartyTonight.domain.picture.dto.request.PictureRequest;
import com.PartyTonight.PartyTonight.domain.picture.service.PictureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("pictures")
public class PictureController implements PictureApi {
    private final PictureService pictureService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Override
    public void createPicture(@Valid @RequestBody PictureRequest request) {
        pictureService.createPicture(request);
    }

}
