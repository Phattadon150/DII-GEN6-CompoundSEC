public class PatientHealthManagementSystem {
    public static void main(String[] args) {
        CardManager cardManager = new CardManager();
        cardManager.issueCard("D123", "อายุรแพทย์");

        Patient patient = new Patient("สมชาย ใจดี", 45, "ความดันโลหิตสูง");
        Doctor doctor = new Doctor("D123", "อายุรแพทย์", cardManager);

        Treatment treatment = patient;
        Prescription prescription = patient;

        boolean checkPassed = doctor.performSecurityCheck("D123", "สั่งจ่ายยา");
        AuditLog.log("D123", "สั่งจ่ายยา", checkPassed);

        if (checkPassed) {
            treatment.prescribeTreatment("ลดความดันโลหิต");
            prescription.givePrescription("ลิซิโนพริล (Lisinopril)");
        }

        System.out.println(patient.getName() + " เป็นผู้ป่วยที่มีประวัติ: " + patient.getMedicalHistory());
    }
}
