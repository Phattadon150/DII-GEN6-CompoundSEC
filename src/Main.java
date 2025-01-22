public class Main {
    public static void main(String[] args) {

        Song song1 = new Song("Shape of You", "Ed Sheeran", 4.24);
        Song song2 = new Song("Blinding Lights", "The Weeknd", 3.50);
        Song song3 = new Song("Someone Like You", "Adele", 4.45);


        Playlist myPlaylist = new Playlist("My Favorites");


        myPlaylist.addSong(song1);
        myPlaylist.addSong(song2);
        myPlaylist.addSong(song3);

        
        myPlaylist.displayPlaylist();
    }
}
