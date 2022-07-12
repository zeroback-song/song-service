package com.song.songv1.api.repository.album;

import com.song.songv1.api.domain.album.Album;

import java.util.Optional;

public interface AlbumCustomRepository {

    Optional<Album> findAlbumById(Long albumId);

}
