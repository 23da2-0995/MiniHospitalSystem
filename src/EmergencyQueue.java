public class EmergencyQueue {

    private Patient[] queue;
    private int front;
    private int rear;
    private int size;

    public EmergencyQueue(int capacity) {
        queue = new Patient[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add patient to queue
    public void enqueue(Patient patient) {

        if (size == queue.length) {
            System.out.println("Queue is full!");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = patient;
        size++;

        System.out.println("Patient added to emergency queue.");
    }

    // Remove next patient
    public Patient dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty!");
            return null;
        }

        Patient patient = queue[front];
        queue[front] = null;

        front = (front + 1) % queue.length;
        size--;

        System.out.println("Patient removed for treatment.");

        return patient;
    }

    // Display waiting patients
    public void displayQueue() {

        if (size == 0) {
            System.out.println("No patients are waiting.");
            return;
        }

        System.out.println("\n--- Emergency Waiting Queue ---");

        int index = front;

        for (int i = 0; i < size; i++) {
            System.out.println(
                queue[index].patientId + " - " +
                queue[index].patientName
            );

            index = (index + 1) % queue.length;
        }
    }
}