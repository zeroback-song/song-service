package com.song.songv1.api.service.album;

import com.song.songv1.api.dto.album.AlbumResponse;

public interface AlbumService {

    AlbumResponse findAlbum(Long albumId);

}
