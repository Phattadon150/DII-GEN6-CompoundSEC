abstract class Security {
    public abstract boolean authenticate(String credential);
    public abstract boolean authorize(String action);

    public boolean performSecurityCheck(String credential, String action) {
        if (authenticate(credential) && authorize(action)) {
            System.out.println("✅ การตรวจสอบสิทธิ์ผ่าน");
            return true;
        } else {
            System.out.println("❌ การตรวจสอบสิทธิ์ล้มเหลว");
            return false;
        }
    }
}
