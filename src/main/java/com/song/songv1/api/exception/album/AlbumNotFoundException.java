package com.song.songv1.api.exception.album;

import com.song.songv1.api.exception.agency.AgencyException;

public class AlbumNotFoundException extends AgencyException {

    private static final String errorMessage = "앨범을 찾지 못했습니다.";
    private static final String errorCode = "404";

    public AlbumNotFoundException() {
        super(errorMessage, errorCode);
    }
}
