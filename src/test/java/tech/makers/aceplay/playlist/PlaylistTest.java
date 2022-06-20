package tech.makers.aceplay.playlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tech.makers.aceplay.playlist.Playlist;
import tech.makers.aceplay.user.*;
import static org.mockito.Mockito.*;

import java.net.MalformedURLException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.youtube.com/watch?v=L4vkcgRnw2g&t=1099s
class PlaylistTest {

private User mockedUser;

@BeforeEach 
public void init() {
  User mockedUser = mock(User.class);
}

  @Test
  void testConstructs() {

    Playlist subject = new Playlist(mockedUser, "Hello, world!", Set.of());
    assertEquals("Hello, world!", subject.getName());
    assertEquals(Set.of(), subject.getTracks());
    assertEquals(null, subject.getId());
  }

  @Test
  void testToString() {
    Playlist subject = new Playlist(mockedUser, "Hello, world!");
    assertEquals(
        "Playlist[id=null name='Hello, world!']",
        subject.toString());
  }
}

