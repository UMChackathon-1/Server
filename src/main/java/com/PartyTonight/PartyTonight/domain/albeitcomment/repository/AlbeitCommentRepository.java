package com.PartyTonight.PartyTonight.domain.albeitcomment.repository;

import com.PartyTonight.PartyTonight.domain.albeitcomment.entity.AlbeitComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbeitCommentRepository extends JpaRepository<AlbeitComment, Long> {
    List<AlbeitComment> findAllByAlbeitBoardId(Long albeitboardId);
}
