package com.PartyTonight.PartyTonight.domain.picture.service;

import com.PartyTonight.PartyTonight.domain.picture.dto.request.PictureRequest;
import com.PartyTonight.PartyTonight.domain.picture.entity.Picture;
import com.PartyTonight.PartyTonight.domain.picture.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PictureService {
    private final PictureRepository pictureRepository;


    @Transactional
    public void createPicture(PictureRequest request) {
        pictureRepository.save(Picture.builder().url(request.getUrl()).build());
    }
}
