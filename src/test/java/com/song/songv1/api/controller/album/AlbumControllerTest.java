package com.song.songv1.api.controller.album;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.album.Genre;
import com.song.songv1.api.domain.song.Song;
import com.song.songv1.api.dto.album.AlbumResponse;
import com.song.songv1.api.repository.album.AlbumRepository;
import com.song.songv1.api.service.album.AlbumService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AlbumControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AlbumService albumService;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private WebApplicationContext ctx;

    @BeforeEach
    void setUpMvc() {
        this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("/api/v1/album 요청시")
    void test() throws Exception {
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
        AlbumResponse response = albumService.findAlbum(savedAlbum.getId());

        // when
        String jsonAlbum = objectMapper.writeValueAsString(response);

        // then
        MvcResult mvcResult = mvc.perform(get("/api/v1/album/{albumId}", savedAlbum.getId())
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(jsonAlbum, mvcResult.getResponse().getContentAsString());
    }

}