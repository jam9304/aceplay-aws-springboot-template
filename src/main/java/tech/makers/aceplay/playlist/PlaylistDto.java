package tech.makers.aceplay.playlist;
import tech.makers.aceplay.user.User;

import java.util.Set;

import tech.makers.aceplay.track.Track;


public class PlaylistDto {

  private String name;
  private Set<Track> tracks;
  private User user;

  public PlaylistDto() {}

  public PlaylistDto(User user, String name) {
    this(user, name, null);
  }

  public PlaylistDto(User user, String name, Set<Track> tracks) {
    this.user = user;
    this.name = name;
    this.tracks = tracks;
  }

  public String getName() {
    return name;
  }

  public Set<Track> getTracks() {
    return tracks;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
