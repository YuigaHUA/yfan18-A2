import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> queue; // Queue to manage visitors waiting for the ride
    private LinkedList<Visitor> rideHistory; // LinkedList to store visitors who have taken the ride

    // Default constructor
    public Ride() {
        this.rideName = "";
        this.capacity = 0;
        this.operator = null;
        this.queue = new LinkedList<>(); // Initialize the queue
        this.rideHistory = new LinkedList<>(); // Initialize the ride history
    }

    // Constructor with parameters
    public Ride(String rideName, int capacity, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.queue = new LinkedList<>(); // Initialize the queue
        this.rideHistory = new LinkedList<>(); // Initialize the ride history
    }

    // Getter and Setter methods for rideName
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    // Getter and Setter methods for capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter and Setter methods for operator
    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // Implementing methods from RideInterface

    // Method to add a visitor to the queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor); // Add visitor to the queue
        System.out.println(visitor.getName() + " has joined the queue.");
    }

    // Method to remove a visitor from the queue
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) { // Remove the visitor if found in the queue
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Visitor not found in the queue.");
        }
    }

    // Method to print the list of visitors in the queue
    @Override
    public void printQueue() {
        System.out.println("Current visitors in the queue:");
        for (Visitor visitor : queue) { // Iterate through the queue and print each visitor
            System.out.println(visitor.getName());
        }
    }

    // Method to run the ride for one cycle and move visitors to history
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned to the ride. Cannot run.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue. Ride cannot run.");
            return;
        }
        int riders = Math.min(queue.size(), capacity); // Determine how many visitors can ride
        System.out.println("Running one cycle of the ride. " + riders + " visitors are taking the ride.");
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll(); // Remove visitor from the queue
            rideHistory.add(visitor); // Add visitor to the ride history
            System.out.println(visitor.getName() + " has taken the ride.");
        }
    }

    // Method to add a visitor to the ride history (after taking the ride)
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor); // Add visitor to the history
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }

    // Method to check if a visitor has already taken the ride
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor); // Check if visitor is in the ride history
    }

    // Method to get the number of visitors who have taken the ride
    @Override
    public int numberOfVisitors() {
        return rideHistory.size(); // Return the number of visitors in the ride history
    }

    // Method to print the ride history (list of visitors who have taken the ride)
    @Override
    public void printRideHistory() {
        System.out.println("Visitors who have taken the ride:");
        for (Visitor visitor : rideHistory) { // Print each visitor in the ride history
            System.out.println(visitor.getName());
        }
    }
}
