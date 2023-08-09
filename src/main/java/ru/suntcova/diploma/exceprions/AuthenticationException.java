package ru.suntcova.diploma.exceprions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String msg) {
        super(msg);
    }
}
