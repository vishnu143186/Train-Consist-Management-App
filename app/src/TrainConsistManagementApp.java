import java.util.LinkedHashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        LinkedHashSet<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        formation.add("Sleeper");

        System.out.println("Final Formation Order: " + formation);
    }
}