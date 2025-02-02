import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class SimpleFeedbackProcessor implements FeedbackProcessor {
    @Override
    public void process(Feedback feedback) {
        System.out.println("Processing feedback: " + feedback);
        openYouTubeSearch(feedback.getMusicPreference().getFavoriteTrack());
    }

    private void openYouTubeSearch(String songName) {
        try {
            String query = songName.replace(" ", "+");
            String url = "https://www.youtube.com/results?search_query=" + query;
            Desktop.getDesktop().browse(new URI(url));
            System.out.println("Opening YouTube for: " + songName);
        } catch (IOException | URISyntaxException e) {
            System.out.println("Failed to open YouTube.");
        }
    }
}