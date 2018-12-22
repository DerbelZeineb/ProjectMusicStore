package com.example.demo.Repositories;

import com.example.demo.model.Album;
import com.example.demo.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SongRepository extends CrudRepository<Song,Long> {
    public List<Song> findSongsByAlbum(Album album);
}
