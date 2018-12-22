package com.example.demo.Repositories;

import com.example.demo.model.Artist;
import com.example.demo.model.Concert;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConcertRepository extends CrudRepository<Concert,Integer> {
   public List<Concert> findConcertsByArtist(Artist artist);
}
