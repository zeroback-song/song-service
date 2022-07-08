package com.song.songv1.api.domain.artist;

import com.song.songv1.api.domain.agency.Agency;
import com.song.songv1.api.domain.common.BaseEntity;
import com.song.songv1.api.domain.common.Nationality;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @JoinColumn(name = "agency_id")
    @OneToOne(fetch = LAZY, orphanRemoval = true)
    Agency agency;

    @Builder
    protected Artist(String name, String debutDate, ActivityType activityType, String introduction, Gender gender, Nationality nationality, String fanClubUrl, Agency agency) {
        this.name = name;
        this.debutDate = debutDate;
        this.activityType = activityType;
        this.introduction = introduction;
        this.gender = gender;
        this.nationality = nationality;
        this.fanClubUrl = fanClubUrl;
        this.agency = agency;
    }

    public void agencyJoin(Agency agency) {
        this.agency = agency;
    }
}
