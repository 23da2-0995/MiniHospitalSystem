public class Patient {
    int patientId;
    String patientName;
    int age;
    String contactNumber;
    String medicalCondition;

    public Patient(int patientId, String patientName, int age,
                   String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
    }

    public void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Contact: " + contactNumber);
        System.out.println("Medical Condition: " + medicalCondition);
    }
}