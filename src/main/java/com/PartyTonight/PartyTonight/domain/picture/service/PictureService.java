package com.PartyTonight.PartyTonight.domain.picture.service;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.service.AuthService;
import com.PartyTonight.PartyTonight.domain.picture.dto.request.PictureRequest;
import com.PartyTonight.PartyTonight.domain.picture.dto.response.PictureDetailResponse;
import com.PartyTonight.PartyTonight.domain.picture.dto.response.PicturePreviewResponse;
import com.PartyTonight.PartyTonight.domain.picture.entity.Picture;
import com.PartyTonight.PartyTonight.domain.picture.entity.PictureDislike;
import com.PartyTonight.PartyTonight.domain.picture.entity.PictureLike;
import com.PartyTonight.PartyTonight.domain.picture.repository.PictureDislikeRepository;
import com.PartyTonight.PartyTonight.domain.picture.repository.PictureLikeRepository;
import com.PartyTonight.PartyTonight.domain.picture.repository.PictureRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PictureService {
    private final AuthService authService;
    private final PictureRepository pictureRepository;
    private final PictureLikeRepository pictureLikeRepository;
    private final PictureDislikeRepository pictureDislikeRepository;

    @Transactional
    public void createPicture(PictureRequest request) {
        Member member = authService.getLoginUser();
        pictureRepository.save(Picture.builder()
                .title(request.getTitle())
                .url(request.getUrl())
                .member(member).build());
    }

    public List<PicturePreviewResponse> getAllPictures() {
        List<Picture> pictures = pictureRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<PicturePreviewResponse> responses = new ArrayList<>();
        pictures.forEach(picture -> responses.add(PicturePreviewResponse.builder()
                .id(picture.getId())
                .url(picture.getUrl())
                .title(picture.getTitle())
                .likeNum(getLikeNum(picture))
                .build()));
        return responses;
    }

    private Integer getLikeNum(Picture picture) {
        return pictureLikeRepository.countByPicture(picture);
    }

    @Transactional
    public PictureDetailResponse getPicture(Long id) {
        Picture picture = pictureRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        picture.increaseViews();
        return PictureDetailResponse.builder()
                .url(picture.getUrl())
                .likeNum(getLikeNum(picture))
                .title(picture.getTitle())
                .dislikeNum(getDislikeNum(picture))
                .downloadCnt(picture.getDownloadCnt())
                .nickname(picture.getMember().getNickname())
                .build();
    }

    private Integer getDislikeNum(Picture picture) {
        return pictureDislikeRepository.countByPicture(picture);
    }

    @Transactional
    public void createLike(Long id) {
        Member member = authService.getLoginUser();
        Picture picture = pictureRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        PictureLike.builder().member(member).picture(picture).build();
    }

    @Transactional
    public void cancelLike(Long id) {
        Member member = authService.getLoginUser();
        Picture picture = pictureRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        PictureLike pictureLike = pictureLikeRepository.findByMemberAndPicture(member, picture);
        pictureLikeRepository.delete(pictureLike);
    }

    @Transactional
    public void createDislike(Long id) {
        Member member = authService.getLoginUser();
        Picture picture = pictureRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        PictureDislike.builder().member(member).picture(picture).build();
    }

    @Transactional
    public void cancelDislike(Long id) {
        Member member = authService.getLoginUser();
        Picture picture = pictureRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        PictureDislike pictureDislike = pictureDislikeRepository.findByMemberAndPicture(member, picture);
        pictureDislikeRepository.delete(pictureDislike);
    }
}
