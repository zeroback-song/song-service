package com.song.songv1.api.repository;

import com.song.songv1.api.domain.album.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
