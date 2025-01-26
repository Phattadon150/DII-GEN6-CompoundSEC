public class Main {
    public static void main(String[] args) {
        Playlist myPlaylist = new Playlist("My Favorites");

        Song song1 = new Song("Shape of You", "Ed Sheeran", 4.24);
        Song song2 = new Song("Blinding Lights", "The Weeknd", 3.50);
        Song song3 = new Song("Someone Like You", "Adele", 4.45);

        myPlaylist.addSong(song1);
        myPlaylist.addSong(song2);
        myPlaylist.addSong(song3);

        // Pass the 'myPlaylist' to PlaylistGUI constructor
        PlaylistGUI playlistGUI = new PlaylistGUI(myPlaylist);
        playlistGUI.updatePlaylistDisplay();
    }
}
