import java.util.HashMap;

public class CardManager {
    private HashMap<String, DoctorCard> cardDatabase = new HashMap<>();

    public void issueCard(String doctorID, String role) {
        cardDatabase.put(doctorID, new DoctorCard(doctorID, role));
    }

    public DoctorCard getCard(String doctorID) {
        return cardDatabase.get(doctorID);
    }

    public void deactivateCard(String doctorID) {
        DoctorCard card = cardDatabase.get(doctorID);
        if (card != null) {
            card.deactivate();
        }
    }
}
