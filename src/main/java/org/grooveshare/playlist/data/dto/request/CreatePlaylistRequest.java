package org.grooveshare.playlist.data.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlaylistRequest {

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Boolean isPublic;

}
