import java.util.Scanner;

public class HospitalAppointmentSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HospitalQueue queue = new HospitalQueue();

        int choice;

        do {
            System.out.println("\n========================================");
            System.out.println("     HOSPITAL APPOINTMENT SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Patient (Enqueue)");
            System.out.println("2. Attend Patient (Dequeue)");
            System.out.println("3. View Next Patient (Front)");
            System.out.println("4. Check Waiting List");
            System.out.println("5. Exit");
            System.out.println("========================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter patient ID: ");
                    String patientId = scanner.nextLine();

                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();

                    System.out.print("Enter appointment type: ");
                    String appointmentType = scanner.nextLine();

                    queue.enqueue(patientId, patientName, appointmentType);
                    break;

                case 2:
                    Node patient = queue.dequeue();

                    if (patient != null) {
                        System.out.println("\n========== PATIENT TO ATTEND ==========");
                        System.out.println("Patient ID: " + patient.patientId);
                        System.out.println("Name: " + patient.patientName);
                        System.out.println("Appointment: " + patient.appointmentType);
                        System.out.println("=======================================");
                    }
                    break;

                case 3:
                    Node nextPatient = queue.front();

                    if (nextPatient != null) {
                        System.out.println("\n========== NEXT PATIENT ==========");
                        System.out.println("Patient ID: " + nextPatient.patientId);
                        System.out.println("Name: " + nextPatient.patientName);
                        System.out.println("Appointment: " + nextPatient.appointmentType);
                        System.out.println("==================================");
                    }
                    break;

                case 4:
                    queue.display();
                    break;

                case 5:
                    System.out.println("\nExiting Hospital Appointment System...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}