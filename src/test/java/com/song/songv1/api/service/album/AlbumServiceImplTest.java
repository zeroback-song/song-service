package com.song.songv1.api.service.album;

import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.album.Genre;
import com.song.songv1.api.domain.song.Song;
import com.song.songv1.api.dto.album.AlbumResponse;
import com.song.songv1.api.exception.album.AlbumNotFoundException;
import com.song.songv1.api.repository.album.AlbumRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    @DisplayName("앨범 조회하기")
    void findAlbumById() {

        // given
        Song song1 = Song.builder()
                .isTitle(true)
                .name("Tomboy1")
                .lyrics("가나다라")
                .lyricWriter("소연1")
                .songWriter("소연1")
                .arranger("미연1")
                .songUrl("www.naver.com")
                .build();

        Song song2 = Song.builder()
                .isTitle(true)
                .name("Tomboy2")
                .lyrics("가나다라마바사")
                .lyricWriter("소연2")
                .songWriter("소연2")
                .arranger("미연2")
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
        AlbumResponse findAlbum = albumService.findAlbum(savedAlbum.getId());

        // then
        assertEquals(savedAlbum.getName(), findAlbum.getName());
        assertEquals(savedAlbum.getSongList().get(0).getName(), song1.getName());
        assertEquals(2, findAlbum.getSongList().size());
    }

    @Test
    @DisplayName("앨범 아이디가 존재하지 않는 경우")
    void findAlbumByWrongId() {

        // given
        Song song1 = Song.builder()
                .isTitle(true)
                .name("Tomboy1")
                .lyrics("가나다라")
                .lyricWriter("소연1")
                .songWriter("소연1")
                .arranger("미연1")
                .songUrl("www.naver.com")
                .build();

        Song song2 = Song.builder()
                .isTitle(false)
                .name("Tomboy2")
                .lyrics("가나다라마바사")
                .lyricWriter("소연2")
                .songWriter("소연2")
                .arranger("미연2")
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

        // then
        AlbumNotFoundException exception = assertThrows(AlbumNotFoundException.class, () ->
                albumService.findAlbum(savedAlbum.getId() + 100));

        assertEquals("404", exception.getErrorCode());
        assertEquals("앨범을 찾지 못했습니다.", exception.getErrorMessage());
    }
}