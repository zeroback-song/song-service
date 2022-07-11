package com.song.songv1.api.exception.album;

import lombok.Getter;

@Getter
public class AlbumException extends RuntimeException {

    private final String errorMessage;
    private final String errorCode;
    public AlbumException(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
