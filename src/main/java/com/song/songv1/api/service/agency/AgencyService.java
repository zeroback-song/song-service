package com.song.songv1.api.service.agency;

import com.song.songv1.api.dto.agency.AgencyCreateRequest;
import com.song.songv1.api.dto.agency.AgencyResponse;

public interface AgencyService {
    Long createAgency(AgencyCreateRequest agency);
    AgencyResponse findAgency(Long agencyId);
}
