public class PatientHealthManagementSystem {
    public static void main(String[] args) {
        // ✅ สร้างอ็อบเจ็กต์ผู้ป่วยและแพทย์
        Patient patient = new Patient("สมชาย ใจดีไหม", 45, "ความดันโลหิตสูง");
        Doctor doctor = new Doctor("D123", "อายุรแพทย์");

        // ✅ ใช้ Upcasting
        Treatment treatment = patient;
        Prescription prescription = patient;

        // ✅ ใช้ Polymorphism กับตรวจสอบสิทธิ์
        if (doctor.performSecurityCheck("D123", "สั่งจ่ายยา")) {
            treatment.prescribeTreatment("ลดความดันโลหิต");
            prescription.givePrescription("ลิซิโนพริล (Lisinopril)");
        }

        // ✅ ใช้ Encapsulation แสดงข้อมูลผู้ป่วย
        System.out.println(patient.getName() + " เป็นผู้ป่วยที่มีประวัติ: " + patient.getMedicalHistory());
    }
}
