//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Create destinations and activities
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 50.0, 10, destination1);
        destination1.addActivity(activity1);

        Destination destination2 = new Destination("Destination 2");
        Activity activity2 = new Activity("Activity 2", "Description 2", 75.0, 15, destination2);
        destination2.addActivity(activity2);

        // Create a travel package with destinations
        List<Destination> itinerary = new ArrayList<>();
        itinerary.add(destination1);
        itinerary.add(destination2);

        TravelPackage travelPackage = new TravelPackage("Package 1", 20, itinerary);

        // Create passengers
        Passenger passenger1 = new Passenger("John", 1, PassengerType.STANDARD, 100.0);
        Passenger passenger2 = new Passenger("Alice", 2, PassengerType.GOLD, 200.0);
        Passenger passenger3 = new Passenger("Bob", 3, PassengerType.PREMIUM, 0.0);

        // Sign up passengers for activities
        passenger1.signUpForActivity(activity1);
        passenger2.signUpForActivity(activity2);
        passenger3.signUpForActivity(activity1);

        // Add passengers to the travel package
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        // Print itinerary and passenger list
        travelPackage.printItinerary();
        travelPackage.printPassengerList();

        // Print available activities at destinations
        destination1.printAvailableActivities();
        destination2.printAvailableActivities();
    }
}