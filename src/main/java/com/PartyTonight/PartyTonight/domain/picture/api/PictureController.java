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

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    @Override
    public void createPicture(@Valid @RequestBody PictureRequest request) {
        pictureService.createPicture(request);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    @Override
    public List<PicturePreviewResponse> getAllPictures() {
        return pictureService.getAllPictures();
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PictureDetailResponse getPicture(@PathVariable final Long id) {
        return pictureService.getPicture(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{id}/like")
    public void createLike(@PathVariable final Long id) {
        pictureService.createLike(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/like")
    public void cancelLike(@PathVariable final Long id) {
        pictureService.cancelLike(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/{id}/dislike")
    public void createDislike(@PathVariable final Long id) {
        pictureService.createDislike(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}/dislike")
    public void cancelDislike(@PathVariable final Long id) {
        pictureService.cancelDislike(id);
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}/download")
    public void download(@PathVariable final Long id) {
        pictureService.dowload(id);
    }
}
