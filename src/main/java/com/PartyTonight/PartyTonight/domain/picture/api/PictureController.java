package com.PartyTonight.PartyTonight.domain.picture.api;

import com.PartyTonight.PartyTonight.domain.picture.dto.request.PictureRequest;
import com.PartyTonight.PartyTonight.domain.picture.dto.response.PictureDetailResponse;
import com.PartyTonight.PartyTonight.domain.picture.dto.response.PicturePreviewResponse;
import com.PartyTonight.PartyTonight.domain.picture.service.PictureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    @Override
    public List<PicturePreviewResponse> getAllPictures() {
        return pictureService.getAllPictures();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PictureDetailResponse getPicture(@PathVariable final Long id) {
        return pictureService.getPicture(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/like/{id}")
    public void createLike(@PathVariable final Long id) {
        pictureService.createLike(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/like/{id}")
    public void cancelLike(@PathVariable final Long id) {
        pictureService.cancelLike(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/dislike/{id}")
    public void createDislike(@PathVariable final Long id) {
        pictureService.createDislike(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/dislike/{id}")
    public void cancelDislike(@PathVariable final Long id) {
        pictureService.cancelDislike(id);
    }
}
