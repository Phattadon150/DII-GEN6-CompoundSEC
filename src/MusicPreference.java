public class MusicPreference {
    private String genre;
    private String favoriteTrack;
    private String mood;
    private String preferredInstrument;

    public MusicPreference(String genre, String favoriteTrack, String mood, String preferredInstrument) {
        this.genre = genre;
        this.favoriteTrack = favoriteTrack;
        this.mood = mood;
        this.preferredInstrument = preferredInstrument;
    }

    public String getGenre() {
        return genre;
    }

    public String getFavoriteTrack() {
        return favoriteTrack;
    }

    public String getMood() {
        return mood;
    }

    public String getPreferredInstrument() {
        return preferredInstrument;
    }

    @Override
    public String toString() {
        return "Genre: " + genre + ", Favorite Track: " + favoriteTrack + ", Mood: " + mood + ", Preferred Instrument: " + preferredInstrument;
    }
}