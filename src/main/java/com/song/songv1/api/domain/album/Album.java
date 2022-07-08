package com.song.songv1.api.domain.album;

import com.song.songv1.api.domain.artist.Artist;
import com.song.songv1.api.domain.common.BaseEntity;
import com.song.songv1.api.domain.song.Song;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Album extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private Long id;

    private String name;

    private Genre genre;

    private String releasedDate;

    private String releaseCompany;

    private String managementAgency;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "album")
    private List<Song> songList = new ArrayList<>();

    @Builder
    public Album(String name, Genre genre, String releasedDate, String releaseCompany, String managementAgency, String imageUrl, Artist artist, List<Song> songList) {
        this.name = name;
        this.genre = genre;
        this.releasedDate = releasedDate;
        this.releaseCompany = releaseCompany;
        this.managementAgency = managementAgency;
        this.imageUrl = imageUrl;
    }

    public void addSong(Song song) {
        this.songList.add(song);
        song.setAlbum(this);
    }
}
