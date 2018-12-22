package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="CONCERT")
public class Concert {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    @Column(name="PLACE")
    String place;
    @Column(name="date")
    String date;
    @Column(name="TIME")
    String time;
    @Column(name="TICKETPRICE")
    float ticketPrice;
    @ManyToOne()
    @JoinColumn(name="artist_id")
    Artist artist;


    public Concert(String place, String date, String time, float ticketPrice) {
        this.place = place;
        this.date = date;
        this.time = time;
        this.ticketPrice = ticketPrice;
    }

    public Concert() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "place='" + place + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
