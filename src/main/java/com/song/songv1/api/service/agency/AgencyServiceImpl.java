package com.song.songv1.api.service.agency;


import com.song.songv1.api.dto.agency.AgencyCreateRequest;
import com.song.songv1.api.dto.agency.AgencyResponse;
import com.song.songv1.api.exception.agency.AgencyNotFoundException;
import com.song.songv1.api.repository.agency.AgencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {

    private final AgencyRepository agencyRepository;

    @Override
    public Long createAgency(AgencyCreateRequest agency) {
        return agencyRepository.save(agency.toEntity()).getId();
    }

    @Override
    public AgencyResponse findAgency(Long agencyId) {
        return AgencyResponse.toResponse(agencyRepository.findAgencyById(agencyId)
                .orElseThrow(AgencyNotFoundException::new));
    }
}
