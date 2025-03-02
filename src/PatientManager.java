import java.util.ArrayList;
import java.util.List;

public class PatientManager {
    private static List<Patient> patients = new ArrayList<>();

    static {
        patients.add(new Patient("P001", "Somchai Jaidee"));
        patients.add(new Patient("P002", "Wilailak Chuenjai"));
        patients.add(new Patient("P003", "Tossapon Saijai"));
    }

    public static List<Patient> getAllPatients() {
        return patients;
    }
}
