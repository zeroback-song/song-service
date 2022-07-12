package com.song.songv1.api.repository.album;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.album.QAlbum;
import com.song.songv1.api.domain.artist.QArtist;
import com.song.songv1.api.domain.song.QSong;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AlbumCustomRepositoryImpl implements AlbumCustomRepository {

    QAlbum album = QAlbum.album;
    QSong song = QSong.song;
    QArtist artist = QArtist.artist;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Album> findAlbumById(Long albumId) {
        return Optional.ofNullable(jpaQueryFactory
                .select(album).from(album)
                .innerJoin(album.songList, song)
                .where(album.id.eq(albumId))
                .leftJoin(album.artist, artist)
                .fetchOne());
    }
}
