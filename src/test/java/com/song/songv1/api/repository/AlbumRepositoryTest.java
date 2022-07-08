package com.song.songv1.api.repository;

import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.album.Genre;
import com.song.songv1.api.domain.song.Song;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlbumRepositoryTest {

    @Autowired
    private AlbumRepository albumRepository;

    @BeforeEach
    void deleteData() {
        albumRepository.deleteAll();
    }

    @Test
    @DisplayName("")
    void createAlbumWithSongs() {

        // given
        Song song1 = Song.builder()
                .isTitle(true)
                .name("Tomboy3")
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


        // when
        Album savedAlbum = albumRepository.save(album);

        // then
        assertEquals(2, savedAlbum.getSongList().size());
    }

}