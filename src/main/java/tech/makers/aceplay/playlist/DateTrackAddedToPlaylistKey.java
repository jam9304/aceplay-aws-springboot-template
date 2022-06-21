package tech.makers.aceplay.playlist;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Column;

@Embeddable
public class DateTrackAddedToPlaylistKey implements Serializable {

    @Column(name = "playlist_id")
    Long playlistId;

    @Column(name = "track_id")
    Long trackId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation


    public Long getPlaylistId() {
        return this.playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getTrackId() {
        return this.trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DateTrackAddedToPlaylistKey)) {
            return false;
        }
        DateTrackAddedToPlaylistKey dateTrackAddedToPlaylist = (DateTrackAddedToPlaylistKey) o;
        return Objects.equals(playlistId, dateTrackAddedToPlaylist.playlistId) && Objects.equals(trackId, dateTrackAddedToPlaylist.trackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, trackId);
    }

}
