package com.PartyTonight.PartyTonight.domain.picture.entity;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Picture extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String url;
    private Integer views;
    private Integer downloadCnt;


    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Picture(String title, String url, Member member) {
        this.title = title;
        this.member = member;
        this.url = url;
        this.views = 0;
        this.downloadCnt = 0;
    }

    public void increaseViews() {
        views++;
    }

    public void increaseDownloadCnt() {
        downloadCnt++;
    }
}
