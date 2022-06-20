package tech.makers.aceplay.playlist;

import java.util.Date;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tech.makers.aceplay.track.Track;
import tech.makers.aceplay.track.TrackRepository;
import tech.makers.aceplay.user.User;
import tech.makers.aceplay.user.UserRepository;
import java.security.Principal;

import static org.springframework.http.HttpStatus.NOT_FOUND;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=0s
@RestController
public class PlaylistsController {
  @Autowired private PlaylistRepository playlistRepository;
  @Autowired private UserRepository userRepository;
  @Autowired private TrackRepository trackRepository;
  @Autowired private DateTrackAddedToPlaylist dateTrackAddedToPlaylist;

  @GetMapping("/api/playlists")
  public Iterable<Playlist> playlists(Principal principal) {
    User user = userRepository.findByUsername(principal.getName());
    Long userId = user.getId();
    return playlistRepository.findByUserId(userId);
  }

  @PostMapping("/api/playlists")
  public Playlist create(@RequestBody PlaylistDto playlistDto, Principal principal) {
    User user = userRepository.findByUsername(principal.getName());
    playlistDto.setUser(user);
    Playlist playlist = new Playlist();
    BeanUtils.copyProperties(playlistDto, playlist);
    return playlistRepository.save(playlist);
  }

  @GetMapping("/api/playlists/{id}")
  public Playlist get(@PathVariable Long id) {
    return playlistRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No playlist exists with id " + id));
  }

  @PutMapping("/api/playlists/{id}/tracks")
  public Track addTrack(@PathVariable Long id, @RequestBody TrackIdentifierDto trackIdentifierDto) {
    // Date dateAddedToPlaylist = new Date();
    Playlist playlist = playlistRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No playlist exists with id " + id));
    Track track = trackRepository.findById(trackIdentifierDto.getId())
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No track exists with id " + trackIdentifierDto.getId()));

    
    playlist.getTracks().add(track); // playlist.getTracks().add(trackAndDate);
    playlistRepository.save(playlist);
    dateTrackAddedToPlaylist;
    return track;
  }
}
