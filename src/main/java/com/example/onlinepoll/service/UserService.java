package com.example.onlinepoll.service;

import com.example.onlinepoll.model.User;
import com.example.onlinepoll.repository.UserRepository;
import com.example.onlinepoll.security.jwt.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.postgresql.util.PSQLException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.InstanceNotFoundException;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new InstanceNotFoundException("user name or password is wrong"));
    }

    public String signing(String username, String password, AuthenticationManager authenticationManager) {
        UserDetails userDetails = loadUserByUsername(username);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return jwtUtils.generateJwtToken(userDetails);
    }

    @SneakyThrows
    public String InsertAdmin() {
        User admin = new User("moheb", "moallem", "moheb12", "moheb123456");
        userRepository.save(admin);
        return "ok";
    }
}
