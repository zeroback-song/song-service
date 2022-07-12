package com.song.songv1.api.controller.album;

import com.song.songv1.api.dto.album.AlbumResponse;
import com.song.songv1.api.service.album.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/album")
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping("/{albumId}")
    public ResponseEntity<AlbumResponse> getAlbum(@PathVariable final Long albumId) {
        AlbumResponse response = albumService.findAlbum(albumId);
        return ResponseEntity.status(OK).body(response);
    }

}
