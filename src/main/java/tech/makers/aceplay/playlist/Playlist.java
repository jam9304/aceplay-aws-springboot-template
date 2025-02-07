package tech.makers.aceplay.playlist;

import com.fasterxml.jackson.annotation.JsonGetter;
import tech.makers.aceplay.track.Track;

import javax.persistence.*;
import java.util.List;

import tech.makers.aceplay.user.User;

// https://www.youtube.com/watch?v=vreyOZxdb5Y&t=448s
@Entity
public class Playlist {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  private List<Track> tracks;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "user_id")
  private User user;

  public Playlist() {}

  public Playlist(String name) {
    this(name, null);
  }

  public Playlist(String name, List<Track> tracks) {

    this.name = name;
    this.tracks = tracks;
  }

  public Playlist(String name, List<Track> tracks, User user) {

    this.name = name;
    this.tracks = tracks;
    this.user = user;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  @JsonGetter("tracks")
  public List<Track> getTracks() {
    if (null == tracks) {
      return List.of();
    }
    return tracks;
  }

  @Override
  public String toString() {
    return String.format("Playlist[id=%d name='%s']", id, name);
  }
}
