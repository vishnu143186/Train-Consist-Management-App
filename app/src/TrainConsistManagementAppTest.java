import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TrainConsistManagementAppTest {

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        // Arrange: Create a list with varied capacities
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("First Class", 24),
                new Bogie("General", 90)
        );

        // Act: Filter for capacity > 60
        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Assert: Expect 2 bogies (Sleeper and General)
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(b -> b.name.equals("Sleeper")));
        assertTrue(result.stream().anyMatch(b -> b.name.equals("General")));
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        // Arrange: Bogie exactly at the boundary
        List<Bogie> bogies = Arrays.asList(new Bogie("Special AC", 60));

        // Act: Filter for capacity > 60 (exclusive)
        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Assert: Result should be empty because 60 is not > 60
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        // Arrange: All bogies below threshold
        List<Bogie> bogies = Arrays.asList(
                new Bogie("First Class", 24),
                new Bogie("Executive", 12)
        );

        // Act
        List<Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        // Arrange
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72));
        int originalSize = bogies.size();

        // Act: Perform stream operation
        bogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());

        // Assert: Stream operations should not modify the source
        assertEquals(String.valueOf(originalSize), bogies.size(), "The source list must remain immutable.");
    }
}