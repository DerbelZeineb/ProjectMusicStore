package com.example.demo.Repositories;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository extends CrudRepository<Album,Integer> {
    public List<Album> findAlbumsByArtist(Artist artist);
    public Album findByName(String name);
}
