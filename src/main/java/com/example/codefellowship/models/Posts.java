package com.example.codefellowship.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String body;
    String createdAt;
    @ManyToOne
    ApplicationUser users;

    public ApplicationUser getOwner() {
        return users;
    }

    public Posts() {
    }

    public long getId() {
        return id;
    }

    public Posts(String body, ApplicationUser users) {
        this.body = body;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        this.createdAt = sdf.format(new Timestamp(System.currentTimeMillis()).getTime());
        this.users = users;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
