import org.junit.Test;
import static org.junit.Assert.*;

public class PassengerTest {

    @Test
    public void getName() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        assertEquals("John", passenger.getName());
    }

    @Test
    public void getNumber() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        assertEquals(1, passenger.getNumber());
    }

    @Test
    public void getType() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        assertEquals(PassengerType.STANDARD, passenger.getType());
    }

    @Test
    public void getBalance() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        assertEquals(100.0, passenger.getBalance(), 0.001); // Using delta for double comparison
    }

    @Test
    public void getActivities() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        assertNotNull(passenger.getActivities());
        assertEquals(0, passenger.getActivities().size());
    }

    @Test
    public void signUpForActivity() {
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        Activity activity = new Activity("TestActivity", "Description", 50.0, 10, new Destination("TestDestination"));

        passenger.signUpForActivity(activity);

        assertEquals(1, passenger.getActivities().size());
        assertEquals(activity, passenger.getActivities().get(0));
    }
}
