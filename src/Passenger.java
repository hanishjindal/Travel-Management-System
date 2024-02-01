import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int number;
    private PassengerType type;
    private double balance;
    private List<Activity> activities;

    public Passenger(String name, int number, PassengerType type, double balance) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public PassengerType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void signUpForActivity(Activity activity) {
        if (activity.getCapacity() > 0) {
            if (type == PassengerType.STANDARD) {
                if (balance >= activity.getCost()) {
                    balance -= activity.getCost();
                    activities.add(activity);
                    activity.reduceCapacity();
                    System.out.println(name + " signed up for " + activity.getName() +
                            " at destination " + activity.getDestination().getName());
                } else {
                    System.out.println("Insufficient balance to sign up for " + activity.getName());
                }
            } else if (type == PassengerType.GOLD) {
                double discountedCost = 0.9 * activity.getCost();
                if (balance >= discountedCost) {
                    balance -= discountedCost;
                    activities.add(activity);
                    activity.reduceCapacity();
                    System.out.println(name + " (Gold) signed up for " + activity.getName() +
                            " at destination " + activity.getDestination().getName() +
                            " with a 10% discount");
                } else {
                    System.out.println("Insufficient balance to sign up for " + activity.getName());
                }
            } else if (type == PassengerType.PREMIUM) {
                activities.add(activity);
                activity.reduceCapacity();
                System.out.println(name + " (Premium) signed up for " + activity.getName() +
                        " at destination " + activity.getDestination().getName() +
                        " for free");
            }
        } else {
            System.out.println("Sorry, " + activity.getName() + " at destination " +
                    activity.getDestination().getName() + " is full. Cannot sign up.");
        }
    }
}
