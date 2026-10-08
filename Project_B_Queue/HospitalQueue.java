public class HospitalQueue {

    private Node front;
    private Node rear;

    // Constructor
    public HospitalQueue() {
        front = null;
        rear = null;
    }

    // Check whether the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Return the number of patients currently in the queue
    public int size() {
        int count = 0;
        Node current = front;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    // Add a patient to the rear
    public void enqueue(String patientId, String patientName, String appointmentType) {
        if (patientId == null || patientId.trim().isEmpty()) {
            System.out.println("\nPatient ID cannot be empty.");
            return;
        }

        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("\nPatient name cannot be empty.");
            return;
        }

        if (appointmentType == null || appointmentType.trim().isEmpty()) {
            System.out.println("\nAppointment type cannot be empty.");
            return;
        }

        Node newNode = new Node(patientId.trim(), patientName.trim(), appointmentType.trim());

        // If the queue is empty, both front and rear point to the new node
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // Attach the new node after the current rear
            rear.next = newNode;

            // Move rear to the new node
            rear = newNode;
        }

        System.out.println("\nPatient added successfully.");
    }

    // Remove and return the patient at the front
    public Node dequeue() {

        if (isEmpty()) {
            System.out.println("\nNo patients are currently waiting.");
            return null;
        }

        Node removedPatient = front;

        // Move front to the next patient
        front = front.next;

        // If queue becomes empty, rear must also become null
        if (front == null) {
            rear = null;
        }

        removedPatient.next = null;

        return removedPatient;
    }

    // View the patient at the front
    public Node front() {

        if (isEmpty()) {
            System.out.println("\nNo patients are currently waiting.");
            return null;
        }

        return front;
    }

    // Display all patients
    public void display() {

        if (isEmpty()) {
            System.out.println("\nNo patients are currently waiting.");
            return;
        }

        Node current = front;

        System.out.println("\n========== WAITING PATIENTS ==========");
        System.out.println("Total patients waiting: " + size());

        int count = 1;
        while (current != null) {
            System.out.println("Position " + count + ":");
            System.out.println("Patient ID: " + current.patientId);
            System.out.println("Name: " + current.patientName);
            System.out.println("Appointment: " + current.appointmentType);
            System.out.println("--------------------------------------");

            current = current.next;
            count++;
        }
    }
}