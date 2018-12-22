package com.example.demo.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="LOGIN")
    @NotEmpty(message = "Please enter a valid login")
    @Length(min=6,max=19)
    private String login;

    @Column(name="PASSWD")
    @NotEmpty(message = "Please enter a valid password")
    @Length(min=5,max=20)
    private String passwd;

    @Column(name="MAIL")
    @Email(message = "Please enter a valid Email")
    @NotEmpty
    private String mail;

    @Column(name="ADMIN")
    private boolean admin;

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isAdmin(){return admin;}

    public User(String login, String passwd, String mail) {
        this.login = login;
        this.passwd = passwd;
        this.mail = mail;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passwd='" + passwd + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
