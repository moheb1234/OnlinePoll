package com.example.onlinepoll.repository;

import com.example.onlinepoll.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PollRepository extends JpaRepository<Poll, Long> {

    Optional<Poll> findByLink(String link);
}
