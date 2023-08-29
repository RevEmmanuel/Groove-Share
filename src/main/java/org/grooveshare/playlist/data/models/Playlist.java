package org.grooveshare.playlist.data.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private String description;

    private String slug;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private UserEntity owner;

    private String coverImage;

    @NotNull
    private Boolean isPublic;

}
