package com.song.songv1.api.repository.agency;

import com.song.songv1.api.domain.agency.Agency;
import com.song.songv1.api.repository.agency.AgencyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AgencyRepositoryTest {

    @Autowired
    private AgencyRepository agencyRepository;

    @Test
    @DisplayName("소속사 등록 테스트")
    @Commit
    void createAgency() {
        // given
        Agency agency = Agency.builder()
                .name("SM")
                .location("강남")
                .foundingDate("2022-07-08")
                .representativeName("ABC")
                .build();

        // when
        Agency savedAgency = agencyRepository.save(agency);

        // then
        assertThat(agency).isEqualTo(savedAgency);
    }

    @Test
    @DisplayName("창립일 10글자 넘어갈 시 에러발생")
    void foundingDateOver() {
        // given
        Agency agency = Agency.builder()
                .name("SM")
                .location("강남")
                .foundingDate("2022-07-081")
                .representativeName("ABC")
                .build();

        // when && then
        assertThrows(DataIntegrityViolationException.class,
                () -> agencyRepository.save(agency));
    }

    @Test
    @DisplayName("소속사 조회 테스트")
    void findAgency() {
        // given
        Agency agency = Agency.builder()
                .name("SM")
                .location("강남")
                .foundingDate("2022-07-08")
                .representativeName("ABC")
                .build();
        Agency savedAgency = agencyRepository.save(agency);

        // when
        Agency findAgency = agencyRepository.findAgencyById(savedAgency.getId())
                .get();

        // then
        assertThat(findAgency.getId()).isEqualTo(savedAgency.getId());
        assertThat(findAgency.getFoundingDate()).isEqualTo(savedAgency.getFoundingDate());
        assertThat(findAgency.getRepresentativeName()).isEqualTo(savedAgency.getRepresentativeName());
        assertThat(findAgency.getName()).isEqualTo(savedAgency.getName());
    }

    @Test
    @DisplayName("소속사 없을 경우")
    void notFindAgency() {
        // given
        Agency agency = Agency.builder()
                .name("SM")
                .location("강남")
                .foundingDate("2022-07-08")
                .representativeName("ABC")
                .build();
        Agency savedAgency = agencyRepository.save(agency);

        // when & then
        assertThrows(NoSuchElementException.class,
                () -> agencyRepository.findAgencyById(savedAgency.getId() + 1L).get());

    }
}