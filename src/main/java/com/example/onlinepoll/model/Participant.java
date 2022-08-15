package com.example.onlinepoll.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PARTICIPANT", schema = "online_poll")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnoreProperties("participant")
    private Set<Option> choices = new HashSet<>();

    @ManyToOne
    @JsonBackReference
    private Poll poll;
}
