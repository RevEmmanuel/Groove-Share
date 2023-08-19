package org.grooveshare.playlist.exceptions;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends PlaylistException {

    public UserNotFoundException() {
        this("Not Found");
    }

    public UserNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

}

