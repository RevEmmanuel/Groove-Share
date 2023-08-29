package org.grooveshare.playlist.data.repository;

import org.grooveshare.playlist.data.models.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository <Playlist, Long> {

}
