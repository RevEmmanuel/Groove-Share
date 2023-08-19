package org.grooveshare.playlist.data.dto.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CreateUserResponse {

    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private LoginResponse loginResponse;

}

