package com.example.onlinepoll.repository;

import com.example.onlinepoll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
