package com.song.songv1.api.repository.agency;

import com.song.songv1.api.domain.agency.Agency;

import java.util.Optional;

/**
 * 소속사 조회용 쿼리
 */
public interface AgencyCustomRepository {
    Optional<Agency> findAgencyById(Long agencyId);
}
