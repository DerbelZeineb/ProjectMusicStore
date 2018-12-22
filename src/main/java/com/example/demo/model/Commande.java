package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Commande")
public class Commande {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
    @Column(name="TOTAL")
    int Price;
    @ManyToOne()
    User user;
    String Achat;

    public String getAchat() {
        return Achat;
    }

    public void setAchat(String achat) {
        Achat = achat;
    }

    public Commande() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
