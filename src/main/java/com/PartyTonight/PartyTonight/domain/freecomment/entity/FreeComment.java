package com.PartyTonight.PartyTonight.domain.freecomment.entity;

import com.PartyTonight.PartyTonight.domain.freeboard.entity.FreeBoard;
import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.global.config.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Builder
@AllArgsConstructor
public class FreeComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_board_id")
    private FreeBoard freeBoard;


    @Builder
    public FreeComment(String content, Member member, FreeBoard freeboard) {
        this.content = content;
        this.member = member;
        this.freeBoard = freeboard;
    }
}
