package org.grooveshare.playlist.service.playlist;

import org.grooveshare.playlist.data.dto.request.CreatePlaylistRequest;
import org.grooveshare.playlist.data.dto.request.CreatePlaylistResponse;
import org.grooveshare.playlist.data.dto.response.FindPlaylistResponse;

public interface PlaylistService {
    FindPlaylistResponse findPlaylistBySlug(String slug);

    CreatePlaylistResponse createPlaylist(CreatePlaylistRequest playlistRequest);
}
