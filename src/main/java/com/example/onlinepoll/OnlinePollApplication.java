package com.example.onlinepoll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@AllArgsConstructor
public class OnlinePollApplication {
//    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlinePollApplication.class, args);
    }
//    @Override
//    public void run(String... args)  {
//        User admin = new User("moheb","moallem","moheb12","moheb123456");
//        userRepository.save(admin);
//    }
}
