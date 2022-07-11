package com.song.songv1.api.repository.album;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.song.songv1.api.domain.album.Album;
import com.song.songv1.api.domain.album.QAlbum;
import com.song.songv1.api.domain.artist.QArtist;
import com.song.songv1.api.domain.song.QSong;
import com.song.songv1.api.dto.album.AlbumResponse;
import com.song.songv1.api.dto.album.QAlbumResponse;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class AlbumCustomRepositoryImpl implements AlbumCustomRepository {

    QAlbum album = QAlbum.album;
    QSong song = QSong.song;
    QArtist artist = QArtist.artist;

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public AlbumResponse findAlbumById(Long albumId) {
        return jpaQueryFactory
                .select(new QAlbumResponse(album.id, album.name, album.genre, album.releasedDate, album.releaseCompany, album.managementAgency, album.imageUrl, album.artist))
                .from(album)
                .innerJoin(album.songList, song)
                .where(album.id.eq(albumId))
                .leftJoin(album.artist, artist)
                .distinct()
                .fetchOne();
    }
}
