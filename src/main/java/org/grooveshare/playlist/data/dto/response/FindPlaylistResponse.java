package org.grooveshare.playlist.data.dto.response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindPlaylistResponse {

    private Long id;
    private String name;
    private String description;
    private String slug;
    private String coverImage;
    private Boolean isPublic;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
