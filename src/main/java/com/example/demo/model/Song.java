package com.example.demo.model;

import javax.persistence.*;

//bech nfassa5 table song
//supposer wa7dou ya3melha 5oudh rahteek :p
@Entity
@Table(name="SONG")
public class Song {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;

    @Column(name="NAME")

    String name;
    @Column(name="RELEASEDATE")
    String releaseDate;
    @Column(name="LENGTH")
    String length;
    @ManyToOne
    @JoinColumn(name="album_id")
    Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Song(String name, String releaseDate, String length) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.length = length;
    }

    public Song() {
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", length='" + length + '\'' +
                '}';
    }
}

