package com.example.onlinepoll;

import com.example.onlinepoll.model.User;
import com.example.onlinepoll.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class OnlinePollApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlinePollApplication.class, args);
    }

    @Override
    public void run(String... args)  {
        User admin = new User("moheb","moallem","moheb12","moheb123456");
        userRepository.save(admin);
    }
}
