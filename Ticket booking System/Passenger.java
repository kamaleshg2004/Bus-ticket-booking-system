public class Passenger {
    private String name;
    private int age;
    private int seatNumber;

    public Passenger(String name, int age, int seatNumber) {
        this.name = name;
        this.age = age;
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "Seat: " + seatNumber + " | Name: " + name + " | Age: " + age;
    }

    public String toCSV() {
        return seatNumber + "," + name + "," + age;
    }

    public static Passenger fromCSV(String csv) {
        String[] data = csv.split(",");
        return new Passenger(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[0]));
    }
}
