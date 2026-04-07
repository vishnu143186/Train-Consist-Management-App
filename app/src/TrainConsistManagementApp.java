import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Renamed from TrainConsistManagementApp to Bogie to match your logic
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Now 'Bogie' is a recognized type
        List<Bogie> passengerBogies = new ArrayList<>();

        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("AC Chair", 56));
        passengerBogies.add(new Bogie("Sleeper", 72));

        // Filtering using Stream API
        List<Bogie> highCapacityBogies = passengerBogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("High Capacity Bogies (> 60 seats):");
        highCapacityBogies.forEach(System.out::println);
    }
}