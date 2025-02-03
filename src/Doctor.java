class Doctor extends Security {
    private String doctorID;
    private String role;

    public Doctor(String doctorID, String role) {
        this.doctorID = doctorID;
        this.role = role;
    }

    @Override
    public boolean authenticate(String credential) {
        // Simple authentication logic (e.g., check doctor ID)
        return credential.equals(doctorID);
    }

    @Override
    public boolean authorize(String action) {
        // Check if the action is authorized for the doctor (e.g., prescribing treatment)
        return action.equals("PRESCRIBE_TREATMENT");
    }
}