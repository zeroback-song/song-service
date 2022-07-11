package com.song.songv1.api.service.album;

import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.album.Genre;
import com.song.songv1.api.domain.song.Song;
import com.song.songv1.api.dto.album.AlbumResponse;
import com.song.songv1.api.repository.album.AlbumRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlbumServiceImplTest {

    @Autowired
    private AlbumService albumService;
    @Autowired
    private AlbumRepository albumRepository;

    @BeforeEach
    void deleteData() {
        albumRepository.deleteAll();
    }

    @Test
    void findAlbumById() {

        // given
        Song song1 = Song.builder()
                .isTitle(true)
                .name("Tomboy4")
                .lyrics("가나다라마바사")
                .lyricWriter("소연")
                .songWriter("소연")
                .arranger("미연")
                .songUrl("www.naver.com")
                .build();

        Song song2 = Song.builder()
                .isTitle(true)
                .name("Tomboy4")
                .lyrics("가나다라마바사")
                .lyricWriter("소연")
                .songWriter("소연")
                .arranger("미연")
                .songUrl("www.naver.com")
                .build();

        Album album = Album.builder()
                .name("톰보이11")
                .genre(Genre.DANCE)
                .releasedDate("2022-04-01")
                .releaseCompany("큐브")
                .managementAgency("큐브")
                .imageUrl("www.naver.com")
                .build();

        album.addSong(song1);
        album.addSong(song2);
        Album savedAlbum = albumRepository.save(album);

        // when
        AlbumResponse findAlbum = albumRepository.findAlbumById(savedAlbum.getId());

        // then
        assertEquals(savedAlbum.getName(), findAlbum.getName());
        assertEquals(savedAlbum.getSongList().get(0).getName(), song1.getName());
    }
}