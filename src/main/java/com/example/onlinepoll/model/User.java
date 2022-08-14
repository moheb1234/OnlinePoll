package com.example.onlinepoll.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER", schema = "online_poll")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstname;

    private String lastname;
}
