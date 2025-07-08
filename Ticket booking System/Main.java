import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketSystem system = new TicketSystem();
        String file = "bookings.txt";

        try {
            system.loadFromFile(file);
        } catch (Exception e) {
            System.out.println("No previous bookings found.");
        }

        int choice;
        do {
            System.out.println("\n==== Ticket Booking System ====");
            System.out.println("1. View Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Save & Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    system.viewSeats();
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Seat No (1-10): ");
                    int seat = sc.nextInt();
                    if (system.bookSeat(name, age, seat)) {
                        System.out.println("Ticket booked!");
                    } else {
                        System.out.println("Seat already booked or invalid.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Seat No to cancel: ");
                    int seatCancel = sc.nextInt();
                    if (system.cancelSeat(seatCancel)) {
                        System.out.println("Booking cancelled.");
                    } else {
                        System.out.println("Seat not booked or invalid.");
                    }
                    break;

                case 4:
                    try {
                        system.saveToFile(file);
                        System.out.println("Data saved. Exiting...");
                    } catch (Exception e) {
                        System.out.println("Error saving file.");
                    }
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 4);

        sc.close();
    }
}
