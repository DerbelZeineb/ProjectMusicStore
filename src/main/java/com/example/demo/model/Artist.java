package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ARTIST")
public class Artist {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @Column(name="NAME")
    String name;
    @Column(name="AGE")
    String age;
    @Column(name="DESCRIPTION")
    String description;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "artist")
    List<Album> albums;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "artist")
    List<Concert> concerts;

    public Artist(String name, String age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Artist() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", description='" + description + '\'' +
                ", albums=" + albums +
                ", concerts=" + concerts +
                '}';
    }
}
