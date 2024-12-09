public class AssignmentTwo {
    public static void main(String[] args) {
        // Create Employee object 
        Employee emp = new Employee("Li Mei", 20, "Female", "Ride Operator", 1001);

        // Create Visitor object 
        Visitor visitor = new Visitor("Wang Wei", 30, "Male", 2024, "wangwei@example.cn");

        // Create Ride object and associate with Employee
        Ride ride = new Ride("Dragon Roller Coaster", 20, emp); 

        // Output to test the objects
        System.out.println("Employee: " + emp.getName() + ", Position: " + emp.getPosition());
        System.out.println("Visitor: " + visitor.getName() + ", Ticket: " + visitor.getTicketNumber());
        System.out.println("Ride: " + ride.getRideName() + ", Operator: " + ride.getOperator().getName());
    }
}
