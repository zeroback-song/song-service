package com.song.songv1.api.repository.agency;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.songv1.api.domain.agency.Agency;
import com.song.songv1.api.domain.agency.QAgency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.song.songv1.api.domain.agency.QAgency.*;

@RequiredArgsConstructor
public class AgencyCustomRepositoryImpl implements AgencyCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Agency> findAgencyById(Long agencyId) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(agency)
                .where(agency.id.eq(agencyId))
                .fetchOne());
    }
}
