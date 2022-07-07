package com.song.songv1.api.domain.song;

import com.song.songv1.api.domain.album.Album;

import javax.persistence.*;

@Entity
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

    @ManyToOne(fetch = FetchType.LAZY)
    private Album album;
}
