import java.util.ArrayList;
import java.util.List;

public class MusicTherapy implements Therapy {
    private List<Feedback> feedbackList = new ArrayList<>();
    private FeedbackProcessor processor;

    // Constructor to accept a FeedbackProcessor
    public MusicTherapy(FeedbackProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);     // Add feedback to the list
        processor.process(feedback);   // Process the feedback
    }

    @Override
    public void summarizeFeedback() {
        System.out.println("---- Feedback Summary (Music Therapy) ----");
        for (Feedback feedback : feedbackList) {
            System.out.println(feedback);
        }
    }
}
