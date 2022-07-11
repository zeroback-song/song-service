package com.song.songv1.api.dto.agency;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AgencyErrorResponse {

    private final String errorMessage;
    private final String errorCode;

    @Builder
    protected AgencyErrorResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
