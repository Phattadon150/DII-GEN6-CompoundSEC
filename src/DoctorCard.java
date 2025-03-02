public class DoctorCard {
    private String doctorID;
    private String role;
    private boolean active = true;

    public DoctorCard(String doctorID, String role) {
        this.doctorID = doctorID;
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }
}
