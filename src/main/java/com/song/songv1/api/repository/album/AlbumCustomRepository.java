package com.song.songv1.api.repository.album;

import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.dto.album.AlbumResponse;

import java.util.Optional;

public interface AlbumCustomRepository {

    AlbumResponse findAlbumById(Long albumId);

}
