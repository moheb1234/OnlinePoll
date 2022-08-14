package com.example.onlinepoll.repository;

import com.example.onlinepoll.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
