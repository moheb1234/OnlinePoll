package com.example.onlinepoll.controller;

import com.example.onlinepoll.model.Poll;
import com.example.onlinepoll.service.PollService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PollController {
    private final PollService pollService;

    @PostMapping("poll/create")
    public ResponseEntity<String> create(@RequestBody Poll poll){
        return new ResponseEntity<>(pollService.create(poll), HttpStatus.CREATED);
    }

    @PutMapping("poll/edit/{link}")
    public ResponseEntity<String> edit(@PathVariable String link , @RequestBody Poll newPoll){
        return ResponseEntity.ok(pollService.edit(link, newPoll));
    }

    @GetMapping("poll/find-by-link/{link}")
    public ResponseEntity<Poll> findByLink(@PathVariable String link){
        return ResponseEntity.ok(pollService.findByLink(link));
    }
}
