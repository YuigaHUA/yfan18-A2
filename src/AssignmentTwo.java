public class AssignmentTwo {
    public static void main(String[] args) {
        // Create an Employee object (ride operator)
        Employee emp = new Employee("Li Mei", 20, "Female", "Ride Operator", 1001);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Wang Wei", 30, "Male", 2023, "wangwei@example.cn");
        Visitor visitor2 = new Visitor("Zhang Wei", 25, "Female", 2024, "zhangwei@example.cn");

        // Create a Ride object and associate with the operator
        Ride ride = new Ride("Dragon Roller Coaster", 2, emp);

        // Add visitors to the queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);

        // Print the current queue of visitors
        ride.printQueue();

        // Run the ride for one cycle
        ride.runOneCycle();

        // Print the ride history (who has taken the ride)
        ride.printRideHistory();

        // Check if a specific visitor has taken the ride
        System.out.println("Has Wang Wei taken the ride? " + ride.checkVisitorFromHistory(visitor1));
    }
}
