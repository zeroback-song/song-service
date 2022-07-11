package com.song.songv1.api.repository.agency;

import com.song.songv1.api.domain.agency.Agency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgencyRepository extends JpaRepository<Agency, Long>,
        AgencyCustomRepository {
}
