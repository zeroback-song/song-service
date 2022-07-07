package com.song.songv1.api.domain.artist;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Gender {

    MALE("남성"),
    FEMALE("여성"),
    MIXED("혼성");

    private final String name;
}
