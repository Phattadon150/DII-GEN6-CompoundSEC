class Doctor extends Security {
    private String doctorID;
    private String role;
    private CardManager cardManager;

    public Doctor(String doctorID, String role, CardManager cardManager) {
        this.doctorID = doctorID;
        this.role = role;
        this.cardManager = cardManager;
    }

    @Override
    public boolean authenticate(String credential) {
        DoctorCard card = cardManager.getCard(doctorID);
        if (card != null && card.isActive() && credential.equals(doctorID)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean authorize(String action) {
        return action.equals("สั่งจ่ายยา");
    }
}
