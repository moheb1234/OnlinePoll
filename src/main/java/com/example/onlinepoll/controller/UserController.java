package com.example.onlinepoll.controller;

import com.example.onlinepoll.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("user/signing")
    public ResponseEntity<String> signing(@RequestParam String username,@RequestParam String password){
        return ResponseEntity.ok(userService.signing(username,password,authenticationManager));
    }
}
