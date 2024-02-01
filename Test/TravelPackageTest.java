import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TravelPackageTest {

    @Test
    public void getName() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 10, new ArrayList<>());
        assertEquals("TestPackage", travelPackage.getName());
    }

    @Test
    public void getPassengerCapacity() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 10, new ArrayList<>());
        assertEquals(10, travelPackage.getPassengerCapacity());
    }

    @Test
    public void getItinerary() {
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Destination1"));
        itinerary.add(new Destination("Destination2"));
        TravelPackage travelPackage = new TravelPackage("TestPackage", 10, itinerary);
        assertEquals(itinerary, travelPackage.getItinerary());
    }

    @Test
    public void getPassengers() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 10, new ArrayList<>());
        assertNotNull(travelPackage.getPassengers());
        assertEquals(0, travelPackage.getPassengers().size());
    }

    @Test
    public void addPassenger() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 1, new ArrayList<>());
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);

        travelPackage.addPassenger(passenger);

        assertEquals(1, travelPackage.getPassengers().size());
        assertEquals(passenger, travelPackage.getPassengers().get(0));
    }

    @Test
    public void printItinerary() {
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(new Destination("Destination1"));
        itinerary.add(new Destination("Destination2"));

        TravelPackage travelPackage = new TravelPackage("TestPackage", 10, itinerary);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        travelPackage.printItinerary();

        // Reset System.out
        System.setOut(System.out);

        // Normalize newline characters
        String expectedOutput = "Travel Package: TestPackage" +
                System.lineSeparator() +
                "Itinerary:" +
                System.lineSeparator() +
                "Destination: Destination1" +
                System.lineSeparator() +
                "Destination: Destination2" +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void printPassengerList() {
        TravelPackage travelPackage = new TravelPackage("TestPackage", 10, new ArrayList<>());
        Passenger passenger = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        travelPackage.addPassenger(passenger);

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        travelPackage.printPassengerList();

        // Reset System.out
        System.setOut(System.out);

        // Normalize newline characters
        String expectedOutput = "Passenger List for TestPackage" +
                System.lineSeparator() +
                "Capacity: 10" +
                System.lineSeparator() +
                "Number of Passengers Enrolled: 1" +
                System.lineSeparator() +
                "  Passenger: John, Number: 1" +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }
}
