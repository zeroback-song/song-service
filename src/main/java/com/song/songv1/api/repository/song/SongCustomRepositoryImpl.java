package com.song.songv1.api.repository.song;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.songv1.api.domain.album.QAlbum;
import com.song.songv1.api.domain.song.QSong;
import com.song.songv1.api.domain.song.Song;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SongCustomRepositoryImpl implements SongCustomRepository {

    QAlbum album = QAlbum.album;
    QSong song = QSong.song;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Song> findByAlbumId(Long albumId) {
        return jpaQueryFactory.selectFrom(song)
                .innerJoin(song.album, album)
                .where(song.album.id.eq(albumId))
                .fetch();
    }
}
