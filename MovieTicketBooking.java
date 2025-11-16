import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seats[][] = new int[5][5]; // 5x5 seat layout

        while (true) {
            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. View Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Show Summary");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

            // View all seats
            case 1:
                System.out.println("\n0 = Free, 1 = Booked\n");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(seats[i][j] + " ");
                    }
                    System.out.println();
                }
                break;

            // Book a seat
            case 2:
                System.out.print("Enter row (0-4): ");
                int r = sc.nextInt();
                System.out.print("Enter column (0-4): ");
                int c = sc.nextInt();

                if (r < 0 || r > 4 || c < 0 || c > 4) {
                    System.out.println("Invalid seat number!");
                    break;
                }

                if (seats[r][c] == 0) {
                    seats[r][c] = 1;

                    int price;
                    if (r <= 1) price = 200;
                    else if (r <= 3) price = 150;
                    else price = 120;

                    System.out.println("Seat booked successfully!");
                    System.out.println("Ticket Price: ₹" + price);
                } else {
                    System.out.println("This seat is already booked!");
                }
                break;

            // Cancel a seat
            case 3:
                System.out.print("Enter row (0-4): ");
                r = sc.nextInt();
                System.out.print("Enter column (0-4): ");
                c = sc.nextInt();

                if (r < 0 || r > 4 || c < 0 || c > 4) {
                    System.out.println("Invalid seat position!");
                    break;
                }

                if (seats[r][c] == 1) {
                    seats[r][c] = 0;
                    System.out.println("Booking cancelled successfully!");
                } else {
                    System.out.println("Seat is already empty!");
                }
                break;

            // Show summary: total seats, booked, free
            case 4:
                int booked = 0;
                int total = 25;

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (seats[i][j] == 1)
                            booked++;
                    }
                }

                System.out.println("\n===== SEAT SUMMARY =====");
                System.out.println("Total Seats: " + total);
                System.out.println("Booked Seats: " + booked);
                System.out.println("Available Seats: " + (total - booked));
                break;

            // Exit
            case 5:
                System.out.println("Exiting… Thank you!");
                sc.close();
                return;

            default:
                System.out.println("Invalid choice!");
            }
        }
    }
}

