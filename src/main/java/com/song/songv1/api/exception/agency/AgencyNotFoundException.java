package com.song.songv1.api.exception.agency;

public class AgencyNotFoundException extends AgencyException {

    private static final String errorMessage = "소속사를 찾지 못했습니다.";
    private static final String errorCode = "505";

    public AgencyNotFoundException() {
        super(errorMessage, errorCode);
    }
}
