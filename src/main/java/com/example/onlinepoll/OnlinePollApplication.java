package com.example.onlinepoll;

import com.example.onlinepoll.model.User;
import com.example.onlinepoll.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication
@AllArgsConstructor
public class OnlinePollApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlinePollApplication.class, args);
    }

    @Override
    public void run(String... args) {
        int count = userRepository.findAll().size();
        if (count == 0) {
            User admin = new User("anes", "hekmat", "anes12", "anes123456");
            userRepository.save(admin);
        }
    }

    @Bean
    public HttpFirewall allowUrlSemicolonHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowSemicolon(true);
        return firewall;
    }
}
