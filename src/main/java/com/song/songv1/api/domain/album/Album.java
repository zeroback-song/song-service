package com.song.songv1.api.domain.album;

import com.song.songv1.api.domain.artist.Artist;
import com.song.songv1.api.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
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

}
