class Patient implements Treatment, Prescription {
    private String name;
    private int age;
    private String medicalHistory;

    public Patient(String name, int age, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    @Override
    public void prescribeTreatment(String treatment) {
        System.out.println(name + " ได้รับการรักษา: " + treatment);
    }

    @Override
    public void givePrescription(String medication) {
        System.out.println(name + " ได้รับยา: " + medication);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }
}
