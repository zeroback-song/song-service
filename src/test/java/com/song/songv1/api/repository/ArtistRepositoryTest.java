package com.song.songv1.api.repository;

import com.song.songv1.api.domain.agency.Agency;
import com.song.songv1.api.domain.artist.ActivityType;
import com.song.songv1.api.domain.artist.Artist;
import com.song.songv1.api.domain.artist.Gender;
import com.song.songv1.api.domain.common.Nationality;
import com.song.songv1.api.repository.artist.ArtistRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Test
    @DisplayName("아티스트 정보 등록 테스트")
    void enrollArtist() {

        // given
        Artist artist = Artist.builder()
                .name("(여자)아이들")
                .debutDate("2010-10-07")
                .activityType(ActivityType.GROUP)
                .introduction("가나다라마바사")
                .gender(Gender.FEMALE)
                .nationality(Nationality.KOREA)
                .fanClubUrl("www.naver.com")
                .build();

        // when
        Artist savedArtist = artistRepository.save(artist);

        // then
        assertEquals(artist, savedArtist);
    }

    @Test
    @DisplayName("아티스트 정보 + 소속사 등록 테스트")
    void enrollArtistWithAgency() {

        // given
        Artist artist = Artist.builder()
                .name("(여자)아이들")
                .debutDate("2010-10-07")
                .activityType(ActivityType.GROUP)
                .introduction("가나다라마바사")
                .gender(Gender.FEMALE)
                .nationality(Nationality.KOREA)
                .fanClubUrl("www.naver.com")
                .build();

        artist.agencyJoin(Agency.builder().build());

        // then
        assertThrows(InvalidDataAccessApiUsageException.class,
                () -> artistRepository.save(artist));

    }

}