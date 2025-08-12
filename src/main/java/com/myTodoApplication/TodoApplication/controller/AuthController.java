package com.myTodoApplication.TodoApplication.controller;

import com.myTodoApplication.TodoApplication.entity.UserEntity;
import com.myTodoApplication.TodoApplication.repository.UserRepo;
import com.myTodoApplication.TodoApplication.utility.Jwt;
import com.myTodoApplication.TodoApplication.utility.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@Lazy
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepo userRepo;
    private final Jwt jwt;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserEntity loginRequest) {
        UserEntity user = userRepo.findByUserName(loginRequest.getUserName());
        if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("");
        }
        String token = jwt.generateToken(user.getUserName());
        return ResponseEntity.ok().body(new ApiResponse<>(HttpStatus.OK.value(), true, "Logged-In successfully" ,token));
    }
}
