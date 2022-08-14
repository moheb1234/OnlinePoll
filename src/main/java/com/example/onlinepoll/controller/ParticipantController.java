package com.example.onlinepoll.controller;

import com.example.onlinepoll.model.Participant;
import com.example.onlinepoll.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ParticipantController {
    private final ParticipantService participantService;

    @PostMapping("participant/create")
    public ResponseEntity<Participant> create(@RequestBody Participant participant , @RequestParam List<Long> selectedOptionsId) {
        return new ResponseEntity<>(participantService.create(participant,selectedOptionsId), HttpStatus.CREATED);
    }
}
