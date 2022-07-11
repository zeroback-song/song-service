package com.song.songv1.api.service.album;

import com.song.songv1.api.dto.album.AlbumResponse;
import com.song.songv1.api.exception.album.AlbumNotFoundException;
import com.song.songv1.api.repository.album.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Override
    public AlbumResponse findAlbum(Long albumId) {
        return albumRepository.findAlbumById(albumId);
    }
}
