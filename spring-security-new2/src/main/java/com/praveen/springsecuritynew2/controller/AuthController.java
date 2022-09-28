package com.praveen.springsecuritynew2.controller;

import com.praveen.springsecuritynew2.model.LoginRequest;
import com.praveen.springsecuritynew2.service.AuthService;
import com.praveen.springsecuritynew2.util.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final AuthService authService;

    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, AuthService authService, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String getLoginPage(@RequestBody LoginRequest loginRequest) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword());

        authenticationManager.authenticate(token);

        UserDetails user = authService.loadUserByUsername(loginRequest.getUserName());

        return jwtUtil.generateToken(user);
    }

}
