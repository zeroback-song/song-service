package com.song.songv1.api.repository.song;

import com.song.songv1.api.domain.song.Song;

import java.util.List;

public interface SongCustomRepository {

    List<Song> findByAlbumId(Long albumId);

}
