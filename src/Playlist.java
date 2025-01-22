
import java.util.ArrayList;

public class Playlist {

    private String name;
    private ArrayList<Song> songs; // A playlist contains multiple songs (Aggregation)

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Added: " + song.getTitle() + " by " + song.getArtist());
    }

    public void displayPlaylist() {
        System.out.println("Playlist: " + name);
        System.out.println("------------------");
        for (Song song : songs) {
            song.displayDetails();
            System.out.println();
        }
    }
}
