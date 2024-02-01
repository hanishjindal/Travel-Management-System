import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DestinationTest {

    @Test
    public void getName() {
        Destination destination = new Destination("TestDestination");
        assertEquals("TestDestination", destination.getName());
    }

    @Test
    public void getActivities() {
        Destination destination = new Destination("TestDestination");
        assertNotNull(destination.getActivities());
        assertEquals(0, destination.getActivities().size());
    }

    @Test
    public void addActivity() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, destination);

        destination.addActivity(activity);

        assertEquals(1, destination.getActivities().size());
        assertEquals(activity, destination.getActivities().get(0));
    }

    @Test
    public void printAvailableActivities() {
        Destination destination = new Destination("TestDestination");
        Activity activity1 = new Activity("Activity1", "Description1", 50.0, 5, destination);
        Activity activity2 = new Activity("Activity2", "Description2", 75.0, 0, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        destination.printAvailableActivities();

        // Reset System.out
        System.setOut(System.out);

        // Normalize newline characters
        String expectedOutput = "Available Activities at TestDestination:" +
                System.lineSeparator() +
                "  Activity: Activity1, Cost: 50.0, Capacity: 5, Description: Description1" +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }
}
