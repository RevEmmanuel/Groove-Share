package org.grooveshare.playlist.utils;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ApiResponse {

    private HttpStatus status;
    private String message;

}

