package com.example.onlinepoll.repository;

import com.example.onlinepoll.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
