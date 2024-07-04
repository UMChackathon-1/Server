package com.PartyTonight.PartyTonight.domain.freeboard.entity;

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
public class FreeBoard extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private Integer views;

    @OneToMany(mappedBy = "freeBoard", cascade = CascadeType.ALL)
    private List<FreeComment> freeCommentList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public FreeBoard(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.views = 0;
    }

    public void increaseViews() {
        views++;
    }

}
