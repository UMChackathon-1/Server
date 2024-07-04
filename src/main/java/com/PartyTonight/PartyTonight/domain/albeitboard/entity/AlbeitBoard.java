package com.PartyTonight.PartyTonight.domain.albeitboard.entity;

import com.PartyTonight.PartyTonight.domain.albeitcomment.entity.AlbeitComment;
import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class AlbeitBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Integer views;

    @OneToMany(mappedBy = "albeitBoard", cascade = CascadeType.ALL)
    private List<AlbeitComment> albeitComments = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public AlbeitBoard(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.views = 0;
    }

    public void increaseViews() {
        views++;
    }

}
