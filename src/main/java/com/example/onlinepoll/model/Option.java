package com.example.onlinepoll.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "OPTION", schema = "online_poll")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "name cant not be empty")
    private String optionName;

    @ManyToOne
    @JsonBackReference
    private Poll poll;

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("choices")
    @JoinTable(name = "PARTICIPANT_CHOICES", schema = "online_poll",
            joinColumns = @JoinColumn(name = "OPTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "PARTICIPANT_ID"))
    private Set<Participant> participants = new HashSet<>();
}
