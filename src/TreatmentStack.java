public class TreatmentStack {

    private Patient[] stack;
    private int top;

    public TreatmentStack(int capacity) {
        stack = new Patient[capacity];
        top = -1;
    }

    // Add completed treatment
    public void push(Patient patient) {

        if (top == stack.length - 1) {
            System.out.println("Treatment stack is full!");
            return;
        }

        top++;
        stack[top] = patient;

        System.out.println("Treatment record added.");
    }

    // Remove most recent treatment
    public Patient pop() {

        if (top == -1) {
            System.out.println("Treatment stack is empty!");
            return null;
        }

        Patient patient = stack[top];
        stack[top] = null;
        top--;

        System.out.println("Last treatment record removed.");

        return patient;
    }

    // Display treatment records
    public void displayStack() {

        if (top == -1) {
            System.out.println("No treatment records available.");
            return;
        }

        System.out.println("\n--- Treatment History ---");

        for (int i = top; i >= 0; i--) {
            System.out.println(
                stack[i].patientId + " - " +
                stack[i].patientName
            );
        }
    }
}
