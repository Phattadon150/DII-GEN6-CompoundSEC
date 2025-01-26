import java.util.ArrayList;

public class Playlist {

    private String name;
    private ArrayList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public String getPlaylistDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist: ").append(name).append("\n");
        sb.append("------------------\n");
        for (Song song : songs) {
            sb.append(song.getSongDetails()).append("\n");
        }
        return sb.toString();
    }
}
