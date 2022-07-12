package com.song.songv1.api.dto.song;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongListResponse {

    private Long id;

    private Boolean isTitle;

    private String name;

    private String lyrics;

    private String lyricWriter;

    private String songWriter;

    private String arranger;

    private String songUrl;

}
