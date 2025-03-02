package manager;

import model.Patient;
import java.util.ArrayList;
import java.util.List;

public class PatientManager {
    private List<Patient> patients = new ArrayList<>();

    public void addPatient(String id, String name, String appointmentTime, String symptoms) {
        patients.add(new Patient(id, name, appointmentTime, symptoms));
    }

    public boolean revokePatient(String patientID) {
        return patients.removeIf(p -> p.getId().equals(patientID));
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }
}
