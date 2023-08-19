package org.grooveshare.playlist.data.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FindUserResponse {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime dateJoined;
    private String imageUrl;

}
