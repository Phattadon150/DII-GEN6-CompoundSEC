package util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuditLog {
    private static List<String> logList = new ArrayList<>();

    public static void log(String doctorID, String action, boolean success) {
        String status = success ? "Success" : "Failure";
        String entry = "Doctor " + doctorID + " performed '" + action + "' at " +
                LocalDateTime.now() + " Status: " + status;

        logList.add(entry);
        System.out.println(entry);
    }
}
