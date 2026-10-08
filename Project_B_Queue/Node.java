public class Node {
    String patientId;
    String patientName;
    String appointmentType;
    Node next;

    public Node(String patientId, String patientName, String appointmentType) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.appointmentType = appointmentType;
        this.next = null;
    }
}