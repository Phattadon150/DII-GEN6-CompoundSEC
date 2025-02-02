public class Feedback {
    private final String feedbackId; // Unique ID to link one-to-one with therapy
    private int feelingRating;
    private int headacheRating;
    private int smellSensitivity;
    private int lightSensitivity;
    private String temperaturePreference;
    private MusicPreference musicPreference;

    public Feedback(String feedbackId, int feelingRating, int headacheRating, int smellSensitivity, int lightSensitivity, String temperaturePreference, MusicPreference musicPreference) {
        this.feedbackId = feedbackId;
        this.feelingRating = feelingRating;
        this.headacheRating = headacheRating;
        this.smellSensitivity = smellSensitivity;
        this.lightSensitivity = lightSensitivity;
        this.temperaturePreference = temperaturePreference;
        this.musicPreference = musicPreference;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public MusicPreference getMusicPreference() {  // ✅ FIX: Added this missing method
        return musicPreference;
    }

    @Override
    public String toString() {
        return "Feedback ID: " + feedbackId + ", Feeling: " + feelingRating + ", Headache: " + headacheRating + ", Smell Sensitivity: " + smellSensitivity + ", Light Sensitivity: " + lightSensitivity + ", Temperature: " + temperaturePreference + ", " + musicPreference;
    }
}