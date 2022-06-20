package tech.makers.aceplay.playlist;

import tech.makers.aceplay.track.Track;

import javax.persistence.*;
import java.util.Date;

@Entity
class DateTrackAddedToPlaylist {

    @EmbeddedId
    DateTrackAddedToPlaylist id;

    @ManyToOne
    @MapsId("playlistId")
    @JoinColumn(name = "playlist_id")
    Playlist playlist;

    @ManyToOne
    @MapsId("trackId")
    @JoinColumn(name = "track_id")
    Track track;

    private Date date;

    public DateTrackAddedToPlaylist(Date date) {
      this.date = date;
    }

    public void setDate(Date date) {
      this.date = new Date();
    }

    public Date getDate() {
      return date;
    }
}