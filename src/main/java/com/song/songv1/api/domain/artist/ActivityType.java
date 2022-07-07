package com.song.songv1.api.domain.artist;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ActivityType {

    GROUP("그룹"),
    SOLO("솔로");

    private final String name;
}
