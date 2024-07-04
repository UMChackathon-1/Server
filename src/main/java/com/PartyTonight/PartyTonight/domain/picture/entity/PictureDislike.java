package com.PartyTonight.PartyTonight.domain.picture.entity;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PictureDislike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public PictureDislike(Picture picture, Member member) {
        this.picture = picture;
        this.member = member;
    }
}
