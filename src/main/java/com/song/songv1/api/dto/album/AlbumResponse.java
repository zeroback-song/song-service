package com.song.songv1.api.dto.album;

import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.album.Genre;
import com.song.songv1.api.domain.artist.Artist;
import com.song.songv1.api.domain.artist.QArtist;
import com.song.songv1.api.domain.song.Song;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AlbumResponse {

    private Long id;

    private String name;

    private Genre genre;

    private String releasedDate;

    private String releaseCompany;

    private String managementAgency;

    private String imageUrl;

    private Artist artist;

    @Builder
    @QueryProjection
    public AlbumResponse(Long id, String name, Genre genre, String releasedDate, String releaseCompany, String managementAgency, String imageUrl, Artist artist) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releasedDate = releasedDate;
        this.releaseCompany = releaseCompany;
        this.managementAgency = managementAgency;
        this.imageUrl = imageUrl;
        this.artist = artist;
    }

    public static AlbumResponse toResponse(Album album) {
        return AlbumResponse.builder()
                .id(album.getId())
                .name(album.getName())
                .genre(album.getGenre())
                .releasedDate(album.getReleasedDate())
                .managementAgency(album.getManagementAgency())
                .imageUrl(album.getImageUrl())
                .build();
    }
}
