package com.song.songv1.api.dto.agency;

import com.song.songv1.api.domain.agency.Agency;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
public class AgencyResponse {

    private Long id;

    private String name;

    private String location;

    private String foundingDate;

    private String representativeName;

    @Builder
    protected AgencyResponse(Long id, String name, String location, String foundingDate, String representativeName) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.foundingDate = foundingDate;
        this.representativeName = representativeName;
    }

    public static AgencyResponse toResponse(Agency agency) {
        return AgencyResponse.builder()
                .id(agency.getId())
                .name(agency.getName())
                .location(agency.getLocation())
                .foundingDate(agency.getFoundingDate())
                .representativeName(agency.getRepresentativeName())
                .build();
    }
}
