public class MusicPreference {
    private String genre;
    private String favoriteTrack;

    public MusicPreference(String genre, String favoriteTrack) {
        this.genre = genre;
        this.favoriteTrack = favoriteTrack;
    }

    public String getGenre() {
        return genre;
    }

    public String getFavoriteTrack() {
        return favoriteTrack;
    }

    @Override
    public String toString() {
        return "Genre: " + genre + ", Favorite Track: " + favoriteTrack;
    }
}
