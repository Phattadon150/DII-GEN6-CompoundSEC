class Doctor extends Security {
    private String doctorID;
    private String role;

    public Doctor(String doctorID, String role) {
        this.doctorID = doctorID;
        this.role = role;
    }

    @Override
    public boolean authenticate(String credential) {
        return credential.equals(doctorID);
    }

    @Override
    public boolean authorize(String action) {
        return action.equals("สั่งจ่ายยา");
    }
}
