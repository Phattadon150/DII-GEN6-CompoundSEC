import java.util.HashMap;
import java.util.Map;

public class MusicTherapy extends AbstractTherapy implements Therapy {
    private Map<String, Feedback> feedbackMap = new HashMap<>(); // One-to-one relationship
    private FeedbackProcessor processor;

    public MusicTherapy(String therapyId, FeedbackProcessor processor) {
        super(therapyId);
        this.processor = processor;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        if (!feedbackMap.containsKey(feedback.getFeedbackId())) { // Ensure one feedback per therapy
            feedbackMap.put(feedback.getFeedbackId(), feedback);
            processor.process(feedback);
        } else {
            System.out.println("Feedback already exists for this therapy session.");
        }
    }

    @Override
    public void summarizeFeedback() {
        System.out.println("---- Feedback Summary (Music Therapy) ----");
        for (Feedback feedback : feedbackMap.values()) {
            System.out.println(feedback);
        }

        suggestSong();
    }

    private void suggestSong() {
        if (feedbackMap.isEmpty()) {
            System.out.println("No feedback available to suggest a song.");
            return;
        }

        Map<String, Integer> genreCount = new HashMap<>();
        for (Feedback feedback : feedbackMap.values()) {
            String genre = feedback.getMusicPreference().getGenre();
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
        }

        String topGenre = genreCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Instrumental");

        openYouTubeSearch(topGenre + " relaxing music");
    }

    private void openYouTubeSearch(String query) {
        try {
            String url = "https://www.youtube.com/results?search_query=" + query.replace(" ", "+");
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
            System.out.println("Opening YouTube for: " + query);
        } catch (Exception e) {
            System.out.println("Failed to open YouTube.");
        }
    }
}