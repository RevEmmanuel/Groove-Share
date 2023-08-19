package org.grooveshare.playlist.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotAuthorizedException extends PlaylistException {

    public UserNotAuthorizedException() {
        this("Unauthorized");
    }

    public UserNotAuthorizedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
