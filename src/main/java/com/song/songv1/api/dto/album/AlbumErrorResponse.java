package com.song.songv1.api.dto.album;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AlbumErrorResponse {

    private final String errorMessage;
    private final String errorCode;

    @Builder
    protected AlbumErrorResponse(String errorMessage, String errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }
}
