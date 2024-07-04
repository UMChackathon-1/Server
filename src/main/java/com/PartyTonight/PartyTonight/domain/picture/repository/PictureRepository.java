package com.PartyTonight.PartyTonight.domain.picture.repository;

import com.PartyTonight.PartyTonight.domain.picture.entity.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}

