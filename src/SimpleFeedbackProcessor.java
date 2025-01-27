
public class SimpleFeedbackProcessor implements FeedbackProcessor {
    @Override
    public void process(Feedback feedback) {
        System.out.println("Processing feedback: " + feedback);
    }
}
