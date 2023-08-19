package org.grooveshare.playlist.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLoginDetailsException extends PlaylistException {

    public InvalidLoginDetailsException() {
        this("Login credentials incorrect!");
    }

    public InvalidLoginDetailsException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
