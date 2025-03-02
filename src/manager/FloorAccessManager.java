package manager;

import model.Role;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class FloorAccessManager {
    private Map<Integer, Role> floorAccessRules = new HashMap<>();
    private Map<Role, LocalTime[]> roleTimeRestrictions = new HashMap<>();

    public FloorAccessManager() {
        // 🔹 กำหนดสิทธิ์เข้าแต่ละชั้น
        floorAccessRules.put(1, Role.ADMIN);
        floorAccessRules.put(2, Role.PHYSICIAN);
        floorAccessRules.put(3, Role.NURSE);
        floorAccessRules.put(4, Role.PHYSICIAN);

        // 🔹 ค่าเริ่มต้นของเวลาเข้า-ออก
        setDefaultTimeRestrictions();
    }

    // 🔹 ตั้งค่าเวลาเริ่มต้น
    private void setDefaultTimeRestrictions() {
        roleTimeRestrictions.put(Role.ADMIN, new LocalTime[]{LocalTime.of(0, 0), LocalTime.of(23, 59)});  // Admin เข้าได้ตลอด
        roleTimeRestrictions.put(Role.PHYSICIAN, new LocalTime[]{LocalTime.of(8, 0), LocalTime.of(18, 0)}); // หมอเข้าได้ 8:00 - 18:00
        roleTimeRestrictions.put(Role.NURSE, new LocalTime[]{LocalTime.of(6, 0), LocalTime.of(22, 0)});  // พยาบาลเข้าได้ 6:00 - 22:00
    }

    public boolean canAccess(int floor, Role userRole) {
        return floorAccessRules.getOrDefault(floor, Role.ADMIN) == userRole;
    }

    public boolean isWithinAccessTime(Role userRole) {
        LocalTime now = LocalTime.now();
        LocalTime[] allowedTime = roleTimeRestrictions.get(userRole);
        return now.isAfter(allowedTime[0]) && now.isBefore(allowedTime[1]);
    }

    // 🔹 ตั้งเวลาเข้า-ออกใหม่ให้กับ Role
    public void setTimeRestriction(Role role, LocalTime startTime, LocalTime endTime) {
        roleTimeRestrictions.put(role, new LocalTime[]{startTime, endTime});
    }

    public LocalTime[] getRoleTimeRestriction(Role role) {
        return roleTimeRestrictions.get(role);
    }
}
