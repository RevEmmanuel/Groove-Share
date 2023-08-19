package org.grooveshare.playlist.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class PlaylistException extends RuntimeException {

    @Getter
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public PlaylistException(){
        this("Error Processing Request!");
    }

    public PlaylistException(String message){
        super(message);
    }

    public PlaylistException(String message, HttpStatus status) {
        this(message);
        this.status = status;
    }

}
