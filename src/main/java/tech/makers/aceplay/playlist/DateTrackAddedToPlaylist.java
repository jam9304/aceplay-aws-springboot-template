package tech.makers.aceplay.playlist;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class DateTrackAddedToPlaylist implements Serializable {

    @Column(name = "playlist_id")
    Long playlistId;

    @Column(name = "track_id")
    Long trackId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}
