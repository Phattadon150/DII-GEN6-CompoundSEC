public class Feedback {
    private int feelingRating; // 1-5
    private int headacheRating; // 1-5
    private int smellSensitivity; // 1-5
    private int lightSensitivity; // 1-5
    private String temperaturePreference; // Hot/Cool

    public Feedback(int feelingRating, int headacheRating, int smellSensitivity, int lightSensitivity, String temperaturePreference) {
        this.feelingRating = feelingRating;
        this.headacheRating = headacheRating;
        this.smellSensitivity = smellSensitivity;
        this.lightSensitivity = lightSensitivity;
        this.temperaturePreference = temperaturePreference;
    }

    @Override
    public String toString() {
        return "Feeling: " + feelingRating +
                ", Headache: " + headacheRating +
                ", Smell Sensitivity: " + smellSensitivity +
                ", Light Sensitivity: " + lightSensitivity +
                ", Temperature: " + temperaturePreference;
    }
}
