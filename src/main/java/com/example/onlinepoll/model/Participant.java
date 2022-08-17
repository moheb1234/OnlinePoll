package com.example.onlinepoll.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "PARTICIPANT", schema = "online_poll")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "empty name is not acceptable ")
    private String name;

    @CreationTimestamp
    private Date createdAt;

    @ManyToMany(mappedBy = "participants")
    @JsonIgnoreProperties("participant")
    private Set<Option> choices = new HashSet<>();

    @ManyToOne
    @JsonBackReference
    private Poll poll;
}
