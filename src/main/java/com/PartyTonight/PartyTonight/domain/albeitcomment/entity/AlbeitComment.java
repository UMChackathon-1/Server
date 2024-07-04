package com.PartyTonight.PartyTonight.domain.albeitcomment.entity;

import com.PartyTonight.PartyTonight.domain.albeitboard.entity.AlbeitBoard;
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
public class AlbeitComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "albeit_board_id")
    private AlbeitBoard albeitBoard;


    @Builder
    public AlbeitComment(String content, Member member, AlbeitBoard albeitBoard) {
        this.content = content;
        this.member = member;
        this.albeitBoard = albeitBoard;
    }
}
