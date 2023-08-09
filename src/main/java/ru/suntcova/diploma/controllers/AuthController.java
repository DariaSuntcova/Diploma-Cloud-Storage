package ru.suntcova.diploma.controllers;


import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.suntcova.diploma.dto.AuthRequest;
import ru.suntcova.diploma.dto.AuthResponse;
import ru.suntcova.diploma.service.AuthService;


@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private static final Logger log = Logger.getLogger(AuthController.class);

    @PostMapping("/login")
    public AuthResponse createAuthToken(@RequestBody AuthRequest authRequest) {
        log.info("POST Request: authorization attempt for LOGIN: " + authRequest.getLogin());
        return authService.createAuthToken(authRequest);
    }
}