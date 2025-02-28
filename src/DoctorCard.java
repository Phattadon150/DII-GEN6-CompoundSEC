public class DoctorCard {
    private String doctorID;
    private String role;
    private boolean active; // true = active, false = deactivated

    public DoctorCard(String doctorID, String role) {
        this.doctorID = doctorID;
        this.role = role;
        this.active = true;
    }

    public void deactivate() {
        this.active = false;
    }

    public boolean isActive() {
        return active;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public String getRole() {
        return role;
    }
}
