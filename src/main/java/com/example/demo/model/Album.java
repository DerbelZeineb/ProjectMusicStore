package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ALBUM")
public class Album {
    @Id
    @Column(name="NAME",unique = true)
    String name;
    @Column(name="RELEASEDATE")
    String releaseDate;
    @Column(name="GENRE")
    String genre;
    @Column(name="LABEL")
    String label;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "album")
    List<Song> songs;
    @Column(name="IMG")
    String img;
    @ManyToOne
    @JoinColumn(name="artist_id")
    Artist artist;

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }



    public Album() {
    }

    public Album(String name, String releaseDate, String genre, String label) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre='" + genre + '\'' +
                ", label='" + label + '\'' +
                ", songs=" + songs +
                '}';
    }
}
