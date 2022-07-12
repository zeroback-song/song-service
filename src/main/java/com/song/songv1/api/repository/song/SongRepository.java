package com.song.songv1.api.repository.song;

import com.song.songv1.api.domain.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long>, SongCustomRepository {
}
