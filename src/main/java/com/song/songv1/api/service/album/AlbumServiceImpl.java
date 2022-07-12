package com.song.songv1.api.service.album;

import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.song.Song;
import com.song.songv1.api.dto.album.AlbumResponse;
import com.song.songv1.api.dto.song.SongListResponse;
import com.song.songv1.api.exception.album.AlbumNotFoundException;
import com.song.songv1.api.repository.album.AlbumRepository;
import com.song.songv1.api.repository.song.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;

    @Override
    public AlbumResponse findAlbum(Long albumId) {
        Album findAlbum = albumRepository.findAlbumById(albumId)
                .orElseThrow(AlbumNotFoundException::new);

        List<Song> findSongs = songRepository.findByAlbumId(albumId);

        return AlbumResponse.builder()
                .id(findAlbum.getId())
                .name(findAlbum.getName())
                .genre(findAlbum.getGenre())
                .releasedDate(findAlbum.getReleasedDate())
                .releaseCompany(findAlbum.getReleaseCompany())
                .managementAgency(findAlbum.getManagementAgency())
                .imageUrl(findAlbum.getImageUrl())
                .artist(findAlbum.getArtist())
                .songList(findSongs
                        .stream()
                        .map(song -> SongListResponse
                                .builder()
                                .id(song.getId())
                                .isTitle(song.getIsTitle())
                                .name(song.getName())
                                .lyrics(song.getLyrics())
                                .lyricWriter(song.getLyricWriter())
                                .songWriter(song.getSongWriter())
                                .arranger(song.getArranger())
                                .songUrl(song.getSongUrl())
                                .build()
                        ).collect(Collectors.toList()))
                .build();
    }
}
