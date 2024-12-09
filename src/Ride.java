import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private Employee operator;
    private Queue<Visitor> queue;  // Queue to manage visitors waiting for the ride
    private LinkedList<Visitor> rideHistory;  // LinkedList to store visitors who have taken the ride
    private HealthPlatformAPI healthAPI;
    private WearableDeviceAPI wearableAPI;

    // Constructor
    public Ride(String rideName, int capacity, Employee operator, HealthPlatformAPI healthAPI, WearableDeviceAPI wearableAPI) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.healthAPI = healthAPI;
        this.wearableAPI = wearableAPI;
    }

    // Method to check if the visitor is fit enough to take the ride based on health data
    public boolean isVisitorFitToRide(Visitor visitor) {
        try {
            int heartRate = healthAPI.getHeartRate(visitor.getName());
            double bloodPressure = wearableAPI.getBloodPressure(visitor.getName());
            double oxygenLevel = wearableAPI.getOxygenLevel(visitor.getName());

            if (heartRate > 120 || bloodPressure > 130 || oxygenLevel < 95) {
                System.out.println(visitor.getName() + " is not fit to take the ride due to health concerns.");
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error fetching health data for visitor " + visitor.getName() + ": " + e.getMessage());
            return false;
        }
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (isVisitorFitToRide(visitor)) {
            queue.add(visitor);  // Add visitor to the queue if they are fit to ride
            System.out.println(visitor.getName() + " has joined the queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {  // Remove the visitor if found in the queue
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Visitor not found in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Current visitors in the queue:");
        for (Visitor visitor : queue) {  // Print all visitors in the queue
            System.out.println(visitor.getName());
        }
    }

    @Override
    public void runOneCycle() {
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue.");
            return;
        }

        int adjustedCapacity = Math.min(queue.size(), capacity);  // Adjust capacity based on queue size
        System.out.println("Running one cycle of the ride with " + adjustedCapacity + " capacity.");

        for (int i = 0; i < adjustedCapacity; i++) {
            Visitor visitor = queue.poll();  // Remove visitor from queue
            rideHistory.add(visitor);  // Add visitor to the ride history
            System.out.println(visitor.getName() + " is taking the ride.");
        }
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride History:");
        for (Visitor visitor : rideHistory) {  // Print all visitors who have taken the ride
            System.out.println(visitor.getName());
        }
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);  // Add visitor to the ride history
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();  // Return the number of visitors who have taken the ride
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);  // Check if the visitor has taken the ride before
    }

    // Method to visualize ride data
    public void visualizeData() {
        int totalVisitors = rideHistory.size();
        System.out.println("\n==== Ride Data Visualization ====");
        System.out.println("Total Visitors Who Took the Ride: " + totalVisitors);

        // Bar chart for ride usage
        System.out.print("Ride Usage: ");
        for (int i = 0; i < totalVisitors; i++) {
            System.out.print("|");
        }
        System.out.println(" (" + totalVisitors + " visitors)");

        // Health Check Pass Rate
        int healthyVisitors = (int) rideHistory.stream()
                .filter(this::isVisitorFitToRide)
                .count();
        double passRate = totalVisitors > 0 ? (double) healthyVisitors / totalVisitors * 100 : 0;
        System.out.println("Health Check Pass Rate: " + String.format("%.2f", passRate) + "%");

        // Age distribution
        System.out.println("\n=== Age Distribution ===");
        rideHistory.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        v -> v.getAge() / 10 * 10,  // Group by age range (e.g., 20s, 30s)
                        java.util.stream.Collectors.counting()))
                .forEach((ageGroup, count) -> {
                    System.out.printf("Age %d-%d: %d visitors\n", ageGroup, ageGroup + 9, count);
                });
    }

    // Method to generate a textual report
    public void generateReport(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("==== Ride Report ====\n");
            writer.write("Ride Name: " + rideName + "\n");
            writer.write("Total Capacity: " + capacity + "\n");
            writer.write("Visitors Who Took the Ride: " + rideHistory.size() + "\n\n");

            writer.write("=== Visitor Health Data ===\n");
            for (Visitor visitor : rideHistory) {
                int heartRate = healthAPI.getHeartRate(visitor.getName());
                int stepCount = healthAPI.getStepCount(visitor.getName());
                double bloodPressure = wearableAPI.getBloodPressure(visitor.getName());
                double oxygenLevel = wearableAPI.getOxygenLevel(visitor.getName());

                writer.write(String.format("Name: %s, Age: %d, Heart Rate: %d bpm, Steps: %d, Blood Pressure: %.2f, Oxygen Level: %.2f%%\n",
                        visitor.getName(), visitor.getAge(), heartRate, stepCount, bloodPressure, oxygenLevel));
            }

            writer.write("\n=== Health Pass Rate ===\n");
            int healthyVisitors = (int) rideHistory.stream()
                    .filter(this::isVisitorFitToRide)
                    .count();
            double passRate = (double) healthyVisitors / rideHistory.size() * 100;
            writer.write("Health Check Pass Rate: " + String.format("%.2f", passRate) + "%\n");

            System.out.println("Detailed report generated successfully: " + fileName);
        } catch (IOException e) {
            System.out.println("Error while generating the report: " + e.getMessage());
        }
    }
}
