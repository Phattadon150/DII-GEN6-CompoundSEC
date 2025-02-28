import java.time.LocalDateTime;

public class AuditLog {
    public static void log(String doctorID, String action, boolean success) {
        String status = success ? "สำเร็จ" : "ล้มเหลว";
        System.out.println("📋 บันทึกการเข้าถึง: หมอ " + doctorID +
                " ทำการ '" + action + "' " +
                "เมื่อ " + LocalDateTime.now() +
                " สถานะ: " + status);
    }
}
