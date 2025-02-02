public abstract class AbstractTherapy {
    private String therapyId; // Unique ID for each therapy session

    public AbstractTherapy(String therapyId) {
        this.therapyId = therapyId;
    }

    public String getTherapyId() {
        return therapyId;
    }

    public abstract void addFeedback(Feedback feedback);
    public abstract void summarizeFeedback();
}
