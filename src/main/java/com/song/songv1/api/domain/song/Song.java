package com.song.songv1.api.domain.song;

import com.song.songv1.api.domain.album.Album;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    private Long id;

    private Boolean isTitle;

    private String name;

    @Lob
    private String lyrics;

    private String lyricWriter;

    private String songWriter;

    private String arranger;

    private String songUrl;

    @JoinColumn(name = "album_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;

    @Builder
    public Song(Boolean isTitle, String name, String lyrics, String lyricWriter, String songWriter, String arranger, String songUrl, Album album) {
        this.isTitle = isTitle;
        this.name = name;
        this.lyrics = lyrics;
        this.lyricWriter = lyricWriter;
        this.songWriter = songWriter;
        this.arranger = arranger;
        this.songUrl = songUrl;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
