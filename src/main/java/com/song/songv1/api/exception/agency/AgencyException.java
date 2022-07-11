package com.song.songv1.api.exception.agency;

import lombok.Getter;

@Getter
public class AgencyException extends RuntimeException {

    private final String errorMessage;
    private final String errorCode;
    public AgencyException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
