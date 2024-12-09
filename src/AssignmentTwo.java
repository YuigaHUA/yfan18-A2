public class AssignmentTwo {
    public static void main(String[] args) {
        // Create an Employee object (ride operator)
        Employee emp = new Employee("Li Mei", 30, "Female", "Ride Operator", 1001);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Wang Wei", 300, "Male", 2023, "wangwei@example.cn");
        Visitor visitor2 = new Visitor("Zhang Wei", 20, "Female", 2024, "zhangwei@example.cn");
        Visitor visitor3 = new Visitor("Li Ming", 25, "Male", 2025, "liming@example.cn");

        // Create a Ride object and associate with the operator
        Ride ride = new Ride("Dragon Roller Coaster", 2, emp);

        // Add visitors to the queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);

        // Run the ride for one cycle
        ride.runOneCycle();

        // Print the ride history before sorting
        System.out.println("\nBefore sorting:");
        ride.printRideHistory();

        // Sort the ride history
        ride.sortRideHistory(); // Sort the ride history

        // Print the ride history after sorting
        System.out.println("\nAfter sorting:");
        ride.printRideHistory();
    }
}
