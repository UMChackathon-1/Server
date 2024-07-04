package com.PartyTonight.PartyTonight.domain.picture.repository;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.picture.entity.Picture;
import com.PartyTonight.PartyTonight.domain.picture.entity.PictureLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureLikeRepository extends JpaRepository<PictureLike, Long> {
    PictureLike findByMemberAndPicture(Member member, Picture picture);

    Integer countByPicture(Picture picture);
}
