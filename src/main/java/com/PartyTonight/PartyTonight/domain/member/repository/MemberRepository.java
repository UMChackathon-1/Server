package com.PartyTonight.PartyTonight.domain.member.repository;

import com.PartyTonight.PartyTonight.domain.member.entity.Member;
import com.PartyTonight.PartyTonight.domain.member.entity.Role;
import com.PartyTonight.PartyTonight.domain.member.entity.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

    Optional<Member> findBySocialTypeAndOauthId(SocialType socialType, String oauthId);

    boolean existsByNicknameAndRole(String nickname, Role role);
    boolean existsByNickname(String nickname);
}

