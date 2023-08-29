package org.grooveshare.playlist.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.grooveshare.playlist.data.dto.request.CreatePlaylistRequest;
import org.grooveshare.playlist.data.dto.request.CreatePlaylistResponse;
import org.grooveshare.playlist.data.dto.response.FindPlaylistResponse;
import org.grooveshare.playlist.service.playlist.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @Operation(summary = "Create a new playlist",
            description = "Returns a Response entity containing the saved playlist and HTTP status code")
    @PostMapping("/create")
    public ResponseEntity<CreatePlaylistResponse> createPlaylist(
            @RequestBody
            @Parameter(name = "CreatePlaylistRequest", description = "The details required to create a playlist which are name, slug, description and isPublic",
                    required = true)
            CreatePlaylistRequest playlistRequest) {
        CreatePlaylistResponse createdPlaylist = playlistService.createPlaylist(playlistRequest);
        return new ResponseEntity<>(createdPlaylist, HttpStatus.CREATED);
    }


    @Operation(summary = "Get A Particular Playlist by the playlist's slug",
            description = "Returns a Response entity containing the requested playlist and HTTP status code")
    @GetMapping("/find")
    public ResponseEntity<FindPlaylistResponse> getPlaylistBySlug(
            @RequestParam
            @Parameter(name = "slug", description = "The slug of the required playlist",
                    required = true, example = "Awake-vibes") @Valid @NotNull
            String slug) {
        FindPlaylistResponse foundPlaylist = playlistService.findPlaylistBySlug(slug);
        return new ResponseEntity<>(foundPlaylist, HttpStatus.OK);
    }


}
