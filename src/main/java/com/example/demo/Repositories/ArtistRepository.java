package com.example.demo.Repositories;


import com.example.demo.model.Artist;
import org.springframework.data.repository.CrudRepository;



public interface ArtistRepository extends CrudRepository<Artist,Integer>
{

}
