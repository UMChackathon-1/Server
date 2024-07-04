package com.PartyTonight.PartyTonight.domain.member.entity;

import com.PartyTonight.PartyTonight.domain.board.entity.Board;
import com.PartyTonight.PartyTonight.domain.comment.entity.Comment;
import com.PartyTonight.PartyTonight.domain.member.dto.SignUpRequest;
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
public class Member extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String oauthId;  //로그인한 소셜 타입의 식별자 값
    private String nickname;
    private String email;
    private String password;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Comment> commentList = new ArrayList<>();

    public void signUp(SignUpRequest dto) {
        this.nickname = dto.getNickname();
        this.role = Role.GUEST;
    }
}
