package com.song.songv1.api.controller.agency;

import com.song.songv1.api.dto.agency.AgencyCreateRequest;
import com.song.songv1.api.dto.agency.AgencyResponse;
import com.song.songv1.api.service.agency.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/agency")
public class AgencyController {

    private final AgencyService agencyService;

    @GetMapping
    public ResponseEntity<AgencyResponse> getAgency(final Long agencyId) {
        AgencyResponse response = agencyService.findAgency(agencyId);
        return ResponseEntity.status(OK).body(response);
    }

    @PostMapping
    public Long createAgency(@RequestBody @Valid final AgencyCreateRequest agencyCreateRequest) {
        return agencyService.createAgency(agencyCreateRequest);
    }
}
