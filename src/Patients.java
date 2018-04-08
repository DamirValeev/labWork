public class Patients {
    private int patientId;
    private String firstNamePatient;
    private String lastNamePatient;
    private int ageOfPatient;

    public Patients() {
    }

    public Patients(String firstNamePatient) {
        this.firstNamePatient = firstNamePatient;
    }

    public Patients(int id, String firstNamePatient, String lastNamePatient, int ageOfPatient) {
        this.patientId = id;
        this.firstNamePatient = firstNamePatient;
        this.lastNamePatient = lastNamePatient;
        this.ageOfPatient = ageOfPatient;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFirstNamePatient() {
        return firstNamePatient;
    }

    public void setFirstNamePatient(String firstNamePatient) {
        this.firstNamePatient = firstNamePatient;
    }

    public String getLastNamePatient() {
        return lastNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
    }

    public int getAgeOfPatient() {
        return ageOfPatient;
    }

    public void setAgeOfPatient(int ageOfPatient) {
        this.ageOfPatient = ageOfPatient;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patientId=" + patientId +
                ", firstNamePatient='" + firstNamePatient + '\'' +
                ", lastNamePatient='" + lastNamePatient + '\'' +
                ", ageOfPatient=" + ageOfPatient +
                '}';
    }
}
