package manager;

import model.DoctorCard;
import model.Role;
import java.util.HashMap;
import java.util.Set;

public class CardManager {
    private HashMap<String, DoctorCard> cardDatabase = new HashMap<>();

    public void issueCard(String doctorID, Role role) {
        cardDatabase.put(doctorID, new DoctorCard(doctorID, role));
    }

    public DoctorCard getCard(String doctorID) {
        return cardDatabase.get(doctorID);
    }

    public boolean revokeDoctor(String doctorID) {
        if (doctorID == null || !cardDatabase.containsKey(doctorID)) {
            return false;
        }
        cardDatabase.remove(doctorID);
        return true;
    }

    public void modifyRole(String doctorID, Role newRole) {
        DoctorCard card = cardDatabase.get(doctorID);
        if (card != null) {
            card.setRole(newRole);
        }
    }

    public boolean revokeCard(String doctorID) { // ✅ ต้องรับค่าเป็น String
        if (doctorID == null || !cardDatabase.containsKey(doctorID)) {
            return false;
        }
        cardDatabase.remove(doctorID);
        return true;
    }

    public Set<String> getAllDoctorIDs() {
        return cardDatabase.keySet();
    }
}
