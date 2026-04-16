import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

//class Bogie {
//    String name;
//    int capacity;
//
//    Bogie(String name, int capacity) {
//        this.name = name;
//        this.capacity = capacity;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getCapacity() {
//        return capacity;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if(this == o) return true;
//        if(o == null || getClass() != o.getClass()) return false;
//        Bogie bogie = (Bogie) o;
//        return capacity == bogie.capacity && Objects.equals(name, bogie.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, capacity);
//    }
//}

public class TrainConsistManagementAppTest {

    private List<Bogie> createBogiesMultiple() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 54),
                new Bogie("First Class", 36)
        );
    }

    private List<Bogie> createBogiesSingle() {
        return Collections.singletonList(new Bogie("Sleeper", 72));
    }

    private List<Bogie> createBogiesEmpty() {
        return Collections.emptyList();
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(72 + 54 + 36, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(162, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = createBogiesSingle();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(72, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = createBogiesEmpty();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createBogiesMultiple();
        List<Integer> capacities = bogies.stream()
                .map(Bogie::getCapacity)
                .toList();
        assertEquals(Arrays.asList(72, 54, 36), capacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createBogiesMultiple();
        int total = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
        int sumManual = 0;
        for (Bogie b : bogies) {
            sumManual += b.getCapacity();
        }
        assertEquals(sumManual, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(createBogiesMultiple());
        List<Bogie> before = new ArrayList<>(bogies);

        bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(before, bogies);
    }
}