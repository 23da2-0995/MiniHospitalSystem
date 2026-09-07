public class VisitHistory {

    // Visit Node
    class VisitNode {
        int visitId;
        String visitDate;
        String doctorName;
        String diagnosis;
        String treatment;
        VisitNode next;

        VisitNode(int visitId, String visitDate, String doctorName,
                  String diagnosis, String treatment) {

            this.visitId = visitId;
            this.visitDate = visitDate;
            this.doctorName = doctorName;
            this.diagnosis = diagnosis;
            this.treatment = treatment;
            this.next = null;
        }
    }

    private VisitNode head;

    // Add a new visit
    public void addVisit(int visitId, String visitDate,
                         String doctorName, String diagnosis,
                         String treatment) {

        VisitNode newNode = new VisitNode(
            visitId,
            visitDate,
            doctorName,
            diagnosis,
            treatment
        );

        if (head == null) {
            head = newNode;
        } else {
            VisitNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Visit added successfully.");
    }

    // Remove a visit
    public void removeVisit(int visitId) {

        if (head == null) {
            System.out.println("Visit history is empty.");
            return;
        }

        if (head.visitId == visitId) {
            head = head.next;
            System.out.println("Visit removed successfully.");
            return;
        }

        VisitNode current = head;

        while (current.next != null &&
               current.next.visitId != visitId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Visit not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Visit removed successfully.");
        }
    }

    // Search for a visit
    public void searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visitId == visitId) {
                System.out.println("\nVisit Found!");
                displayVisit(current);
                return;
            }

            current = current.next;
        }

        System.out.println("Visit not found.");
    }

    // Display all visits
    public void displayHistory() {

        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }

        System.out.println("\n--- Patient Visit History ---");

        VisitNode current = head;

        while (current != null) {
            displayVisit(current);
            current = current.next;
        }
    }

    // Display one visit
    private void displayVisit(VisitNode visit) {

        System.out.println("----------------------------");
        System.out.println("Visit ID: " + visit.visitId);
        System.out.println("Date: " + visit.visitDate);
        System.out.println("Doctor: " + visit.doctorName);
        System.out.println("Diagnosis: " + visit.diagnosis);
        System.out.println("Treatment: " + visit.treatment);
    }
}