package com.example.onlinepoll.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PARTICIPANT")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "PARTICIPANT_CHOICES",
            joinColumns = @JoinColumn(name = "PARTICIPANT_ID"),
            inverseJoinColumns = @JoinColumn(name = "OPTION_ID"))
    private Set<Option> choices = new HashSet<>();

    @ManyToOne
    @JsonIgnore
    private Poll poll;
}
