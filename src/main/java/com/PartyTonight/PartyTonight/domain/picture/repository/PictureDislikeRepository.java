package com.PartyTonight.PartyTonight.domain.picture.repository;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.picture.entity.Picture;
import com.PartyTonight.PartyTonight.domain.picture.entity.PictureDislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureDislikeRepository extends JpaRepository<PictureDislike, Long> {
    PictureDislike findByMemberAndPicture(Member member, Picture picture);

    Integer countByPicture(Picture picture);

    Boolean existsByMemberAndPicture(Member member, Picture picture);

}
