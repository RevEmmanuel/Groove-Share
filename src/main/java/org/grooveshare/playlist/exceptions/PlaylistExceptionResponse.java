package org.grooveshare.playlist.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistExceptionResponse {

    private Map<String, String> data;
    private String message;
    private HttpStatus status;

}
