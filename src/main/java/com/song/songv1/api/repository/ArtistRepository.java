package com.song.songv1.api.repository;

import com.song.songv1.api.domain.artist.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
