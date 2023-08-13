package ru.suntcova.diploma.service;

import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.suntcova.diploma.dto.AuthRequest;
import ru.suntcova.diploma.dto.AuthResponse;
import ru.suntcova.diploma.exceptions.AuthenticationException;
import ru.suntcova.diploma.jwt.JwtTokenUtils;


@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;
    private static final Logger log = Logger.getLogger(AuthService.class);

    public AuthResponse createAuthToken(AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.error("Wrong password");
            throw new AuthenticationException("Bad credentials");
        }
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getLogin());
        String token = jwtTokenUtils.generateToken(userDetails);
        return new AuthResponse(token);
    }
}