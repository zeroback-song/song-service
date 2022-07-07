package com.song.songv1.api.domain.album;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Genre {

    DANCE("댄스"),
    BALLAD("발라드");

    private final String name;
}
