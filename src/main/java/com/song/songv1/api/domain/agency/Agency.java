package com.song.songv1.api.domain.agency;

import com.song.songv1.api.domain.common.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Agency extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agency_id")
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 255)
    private String location;

    @Column(length = 10)
    private String foundingDate;

    @Column(length = 50)
    private String representativeName;
}