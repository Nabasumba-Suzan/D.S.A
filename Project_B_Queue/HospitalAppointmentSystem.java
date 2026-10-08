import java.util.Scanner;

public class HospitalAppointmentSystem {

    private static String readNonEmptyInput(Scanner scanner, String prompt) {
        String input;

        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();

            if (input != null && !input.trim().isEmpty()) {
                return input.trim();
            }

            System.out.println("\nValue cannot be empty. Please try again.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HospitalQueue queue = new HospitalQueue();

        int choice;

        do {
            
            System.out.println("     HOSPITAL APPOINTMENT SYSTEM");
            
            System.out.println("1. Add Patient (Enqueue)");
            System.out.println("2. Attend Patient (Dequeue)");
            System.out.println("3. View Next Patient (Front)");
            System.out.println("4. Check Waiting List");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("\nInvalid choice. Please enter a number from 1 to 5.");
                System.out.print("Enter your choice: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
            
                        
                case 1:
                    String patientId = readNonEmptyInput(scanner, "Enter patient ID: ");
                    String patientName = readNonEmptyInput(scanner, "Enter patient name: ");
                    String appointmentType = readNonEmptyInput(scanner, "Enter appointment type: ");

                    queue.enqueue(patientId, patientName, appointmentType);
                    break;

                case 2:
                    Node patient = queue.dequeue();

                    if (patient != null) {
                        System.out.println("\n  PATIENT TO ATTEND ");
                        System.out.println("Patient ID: " + patient.patientId);
                        System.out.println("Name: " + patient.patientName);
                        System.out.println("Appointment: " + patient.appointmentType);
                        ;
                    }
                    break;

                case 3:
                    Node nextPatient = queue.front();

                    if (nextPatient != null) {
                        System.out.println("\n  NEXT PATIENT IN LINE ");
                        System.out.println("Patient ID: " + nextPatient.patientId);
                        System.out.println("Name: " + nextPatient.patientName);
                        System.out.println("Appointment: " + nextPatient.appointmentType);
                        
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