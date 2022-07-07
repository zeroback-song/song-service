package com.song.songv1.api.domain.artist;

import com.song.songv1.api.domain.agency.Agency;
import com.song.songv1.api.domain.common.BaseEntity;
import com.song.songv1.api.domain.common.Nationality;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class Artist extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Long id;

    private String name;

    private String debutDate;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType;

    @Lob
    private String introduction;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Nationality nationality;

    @Lob
    private String fanClubUrl;

    @OneToOne(fetch = LAZY, orphanRemoval = true)
    Agency agency;
}
