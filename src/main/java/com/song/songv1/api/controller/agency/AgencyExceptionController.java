package com.song.songv1.api.controller.agency;

import com.song.songv1.api.dto.agency.AgencyErrorResponse;
import com.song.songv1.api.exception.agency.AgencyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class AgencyExceptionController {

    @ExceptionHandler(AgencyException.class)
    public ResponseEntity<AgencyErrorResponse> agencyException(AgencyException e) {
        AgencyErrorResponse errorResponse = AgencyErrorResponse.builder()
                .errorMessage(e.getErrorMessage())
                .errorCode(e.getErrorCode())
                .build();

        return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
    }
}
