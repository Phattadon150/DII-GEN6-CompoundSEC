package model;

public class Patient {
    private String id;
    private String name;
    private String appointmentTime;
    private String symptoms;
    private String assignedDoctor;

    public Patient(String id, String name, String appointmentTime, String symptoms) {
        this.id = id;
        this.name = name;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        this.assignedDoctor = "Not Assigned";
    }

    public void assignDoctor(String doctorID) {
        this.assignedDoctor = doctorID;
    }

    public String getAssignedDoctor() {
        return assignedDoctor;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getAppointmentTime() { return appointmentTime; }
    public String getSymptoms() { return symptoms; }
}
