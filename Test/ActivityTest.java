import org.junit.Test;
import static org.junit.Assert.*;

public class ActivityTest {

    @Test
    public void getName() {
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, new Destination("TestDestination"));
        assertEquals("TestActivity", activity.getName());
    }

    @Test
    public void getDescription() {
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, new Destination("TestDestination"));
        assertEquals("Description", activity.getDescription());
    }

    @Test
    public void getCost() {
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, new Destination("TestDestination"));
        assertEquals(50.0, activity.getCost(), 0.001); // Using delta for double comparison
    }

    @Test
    public void getCapacity() {
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, new Destination("TestDestination"));
        assertEquals(10, activity.getCapacity());
    }

    @Test
    public void getDestination() {
        Destination destination = new Destination("TestDestination");
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, destination);
        assertEquals(destination, activity.getDestination());
    }

    @Test
    public void reduceCapacity() {
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, new Destination("TestDestination"));
        activity.reduceCapacity();
        assertEquals(9, activity.getCapacity());
    }
}
