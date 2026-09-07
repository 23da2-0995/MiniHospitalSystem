import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue(50);
        TreatmentStack treatmentStack = new TreatmentStack(50);
        VisitHistory visitHistory = new VisitHistory();

        int choice;

        do {
            System.out.println("\n==========================================");
            System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT");
            System.out.println("==========================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Add Emergency Patient");
            System.out.println("6. Treat Next Patient");
            System.out.println("7. Display Waiting Queue");
            System.out.println("8. Add Treatment Record");
            System.out.println("9. Remove Last Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Patient Visit");
            System.out.println("12. Remove Patient Visit");
            System.out.println("13. Search Patient Visit");
            System.out.println("14. Display Visit History");
            System.out.println("0. Exit");
            System.out.println("==========================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // 1. Add Patient
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient patient = new Patient(
                            id, name, age, contact, condition
                    );

                    patientBST.insert(patient);

                    System.out.println("Patient added successfully!");
                    break;

                // 2. Search Patient
                case 2:
                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();

                    Patient foundPatient = patientBST.search(searchId);

                    if (foundPatient != null) {
                        System.out.println("\nPatient Found!");
                        foundPatient.displayPatient();
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // 3. Delete Patient
                case 3:
                    System.out.print("Enter Patient ID to delete: ");
                    int deleteId = scanner.nextInt();

                    if (patientBST.search(deleteId) != null) {
                        patientBST.delete(deleteId);
                        System.out.println("Patient deleted successfully!");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // 4. Display All Patients
                case 4:
                    System.out.println("\n--- All Patients ---");
                    patientBST.inOrder();
                    break;

                // 5. Add Emergency Patient
                case 5:
                    System.out.print("Enter Patient ID: ");
                    int emergencyId = scanner.nextInt();

                    Patient emergencyPatient =
                            patientBST.search(emergencyId);

                    if (emergencyPatient != null) {
                        emergencyQueue.enqueue(emergencyPatient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // 6. Treat Next Patient
                case 6:
                    Patient nextPatient = emergencyQueue.dequeue();

                    if (nextPatient != null) {
                        System.out.println(
                                "Now treating: "
                                        + nextPatient.patientName
                        );

                        treatmentStack.push(nextPatient);
                    }
                    break;

                // 7. Display Waiting Queue
                case 7:
                    emergencyQueue.displayQueue();
                    break;

                // 8. Add Treatment Record
                case 8:
                    System.out.print("Enter Patient ID: ");
                    int treatmentId = scanner.nextInt();

                    Patient treatmentPatient =
                            patientBST.search(treatmentId);

                    if (treatmentPatient != null) {
                        treatmentStack.push(treatmentPatient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                // 9. Remove Last Treatment
                case 9:
                    treatmentStack.pop();
                    break;

                // 10. Display Treatment History
                case 10:
                    treatmentStack.displayStack();
                    break;

                // 11. Add Patient Visit
                case 11:
                    System.out.print("Enter Visit ID: ");
                    int visitId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Visit Date: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctor = scanner.nextLine();

                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    System.out.print("Enter Treatment: ");
                    String treatment = scanner.nextLine();

                    visitHistory.addVisit(
                            visitId,
                            date,
                            doctor,
                            diagnosis,
                            treatment
                    );
                    break;

                // 12. Remove Patient Visit
                case 12:
                    System.out.print("Enter Visit ID to remove: ");
                    int removeVisitId = scanner.nextInt();

                    visitHistory.removeVisit(removeVisitId);
                    break;

                // 13. Search Patient Visit
                case 13:
                    System.out.print("Enter Visit ID to search: ");
                    int searchVisitId = scanner.nextInt();

                    visitHistory.searchVisit(searchVisitId);
                    break;

                // 14. Display Visit History
                case 14:
                    visitHistory.displayHistory();
                    break;

                // Exit
                case 0:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }
}