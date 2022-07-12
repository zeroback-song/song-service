package com.song.songv1.api.dto.album;

import com.song.songv1.api.domain.album.Genre;
import com.song.songv1.api.domain.artist.Artist;
import com.song.songv1.api.dto.song.SongListResponse;
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

    private List<SongListResponse> songList;

    @Builder
    public AlbumResponse(Long id, String name, Genre genre, String releasedDate, String releaseCompany, String managementAgency, String imageUrl, Artist artist, List<SongListResponse> songList) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.releasedDate = releasedDate;
        this.releaseCompany = releaseCompany;
        this.managementAgency = managementAgency;
        this.imageUrl = imageUrl;
        this.artist = artist;
        this.songList = songList;
    }
}
