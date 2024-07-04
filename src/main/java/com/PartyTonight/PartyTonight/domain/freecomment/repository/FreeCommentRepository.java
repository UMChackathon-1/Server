package com.PartyTonight.PartyTonight.domain.freecomment.repository;

import com.PartyTonight.PartyTonight.domain.freecomment.entity.FreeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreeCommentRepository extends JpaRepository<FreeComment, Long> {
    List<FreeComment> findAllByFreeBoardId(Long freeboardId);
}
