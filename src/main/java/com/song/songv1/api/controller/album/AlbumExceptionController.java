package com.song.songv1.api.controller.album;

import com.song.songv1.api.dto.album.AlbumErrorResponse;
import com.song.songv1.api.exception.album.AlbumException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class AlbumExceptionController {

    @ExceptionHandler(AlbumException.class)
    public ResponseEntity<AlbumErrorResponse> albumException(AlbumException e) {
        AlbumErrorResponse errorResponse = AlbumErrorResponse.builder()
                .errorMessage(e.getErrorMessage())
                .errorCode(e.getErrorCode())
                .build();

        return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
    }
}
