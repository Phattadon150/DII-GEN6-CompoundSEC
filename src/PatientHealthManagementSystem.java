public class PatientHealthManagementSystem {
    public static void main(String[] args) {
        // Create a Patient instance
        Patient patient = new Patient("John Doe", 30, "Hypertension");

        // Create a Doctor instance with ID and role
        Doctor doctor = new Doctor("D123", "Physician");

        // Upcasting: treating the Patient as a Treatment and Prescription interface
        Treatment treatment = patient;
        Prescription prescription = patient;

        // Doctor performs an action (authentication and authorization check)
        doctor.performDoctorAction("D123", "PRESCRIBE_TREATMENT");

        // Doctor prescribes treatment and medication
        treatment.prescribeTreatment("Blood Pressure Medication");
        prescription.givePrescription("Lisinopril");

        // Check the instance type using 'instanceof' (e.g., check if patient is an instance of Patient)
        if (patient instanceof Patient) {
            System.out.println(patient.getName() + " is a patient.");
        }
    }
}