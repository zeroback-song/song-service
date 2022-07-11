package com.song.songv1.api.dto.agency;

import com.song.songv1.api.domain.agency.Agency;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
public class AgencyCreateRequest {

    @NotEmpty
    @Max(value = 50)
    private String name;

    @NotEmpty
    @Max(value = 255)
    private String location;

    @NotEmpty
    @Max(value = 10)
    private String foundingDate;

    @NotEmpty
    @Max(value = 50)
    private String representativeName;

    public Agency toEntity() {
        return Agency.builder()
                .name(this.name)
                .representativeName(this.representativeName)
                .foundingDate(this.foundingDate)
                .location(this.location)
                .build();
    }
}
