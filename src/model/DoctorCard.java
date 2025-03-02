package model;

public class DoctorCard {
    private String doctorID;
    private Role role;

    public DoctorCard(String doctorID, Role role) {
        this.doctorID = doctorID;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDoctorID() {
        return doctorID;
    }
}
