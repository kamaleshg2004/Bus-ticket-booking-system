import java.io.*;
import java.util.*;

public class TicketSystem {
    private final int totalSeats = 50;
    private Passenger[] seats = new Passenger[totalSeats];

    public boolean bookSeat(String name, int age, int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats) return false;
        if (seats[seatNumber - 1] == null) {
            seats[seatNumber - 1] = new Passenger(name, age, seatNumber);
            return true;
        }
        return false;
    }

    public boolean cancelSeat(int seatNumber) {
        if (seatNumber < 1 || seatNumber > totalSeats) return false;
        if (seats[seatNumber - 1] != null) {
            seats[seatNumber - 1] = null;
            return true;
        }
        return false;
    }

    public void viewSeats() {
        for (int i = 0; i < totalSeats; i++) {
            if (seats[i] == null) {
                System.out.println("Seat " + (i + 1) + " is available.");
            } else {
                System.out.println(seats[i]);
            }
        }
    }

    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Passenger p : seats) {
                if (p != null) {
                    bw.write(p.toCSV());
                    bw.newLine();
                }
            }
        }
    }

    public void loadFromFile(String fileName) throws IOException {
        seats = new Passenger[totalSeats]; // reset
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                Passenger p = Passenger.fromCSV(line);
                seats[p.getSeatNumber() - 1] = p;
            }
        }
    }
}
