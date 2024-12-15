public class AssignmentTwo {

    public static void main(String[] args) {
        // Create an instance of AssignmentTwo to call each part's method
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    // Part 3: Test health data from the health platform and check visitor health
    public void partThree() {
        // Assuming you have created the HealthPlatformAPI and WearableDeviceAPI objects
        HealthPlatformAPI healthAPI = new HealthPlatformAPIImpl();
        WearableDeviceAPI wearableAPI = new WearableDeviceAPIImpl();

        // Create a Visitor object
        Visitor visitor1 = new Visitor("Wang Wei", 40, "Male", 2023, "wangwei@example.cn");
        
        // Simulate fetching health data
        int heartRate = healthAPI.getHeartRate(visitor1.getName());
        double bloodPressure = wearableAPI.getBloodPressure(visitor1.getName());
        double oxygenLevel = wearableAPI.getOxygenLevel(visitor1.getName());

        // Output the health data
        System.out.println("Visitor: " + visitor1.getName());
        System.out.println("Heart Rate: " + heartRate + " bpm");
        System.out.println("Blood Pressure: " + bloodPressure);
        System.out.println("Oxygen Level: " + oxygenLevel + "%");
    }

    // Part 4A: Test visitor health data and manage visitor history
    public void partFourA() {
        // Create an Employee and Ride object
        Employee emp = new Employee("Li Mei", 30, "Female", "Ride Operator", 1001);
        HealthPlatformAPI healthAPI = new HealthPlatformAPIImpl();
        WearableDeviceAPI wearableAPI = new WearableDeviceAPIImpl();
        
        Ride ride = new Ride("Dragon Roller Coaster", 10, emp, healthAPI, wearableAPI);

        // Create visitors and add them to the queue
        Visitor visitor1 = new Visitor("Wang Wei", 40, "Male", 2023, "wangwei@example.cn");
        Visitor visitor2 = new Visitor("Zhang Wei", 25, "Female", 2024, "zhangwei@example.cn");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        
        // Run the ride for one cycle
        ride.runOneCycle();

        // Print the ride history
        ride.printRideHistory();
    }

    // Part 4B: Sort visitor history and visualize data
    public void partFourB() {
        // Using the same Ride object
        Employee emp = new Employee("Li Mei", 30, "Female", "Ride Operator", 1001);
        HealthPlatformAPI healthAPI = new HealthPlatformAPIImpl();
        WearableDeviceAPI wearableAPI = new WearableDeviceAPIImpl();
        
        Ride ride = new Ride("Dragon Roller Coaster", 10, emp, healthAPI, wearableAPI);

        // Create visitors and add them to the queue
        Visitor visitor1 = new Visitor("Wang Wei", 40, "Male", 2023, "wangwei@example.cn");
        Visitor visitor2 = new Visitor("Zhang Wei", 25, "Female", 2024, "zhangwei@example.cn");
        Visitor visitor3 = new Visitor("Li Ming", 30, "Male", 2025, "liming@example.cn");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        
        // Run the ride for one cycle
        ride.runOneCycle();
        
        // Visualize the ride data
        ride.visualizeData();
    }

    // Part 5: Health check and visitor reservation management
    public void partFive() {
        // Using the same Ride object
        Employee emp = new Employee("Li Mei", 30, "Female", "Ride Operator", 1001);
        HealthPlatformAPI healthAPI = new HealthPlatformAPIImpl();
        WearableDeviceAPI wearableAPI = new WearableDeviceAPIImpl();
        
        Ride ride = new Ride("Dragon Roller Coaster", 10, emp, healthAPI, wearableAPI);

        // Create a visitor and add a reservation
        Visitor visitor1 = new Visitor("Wang Wei", 40, "Male", 2023, "wangwei@example.cn");
        visitor1.makeReservation(java.time.LocalDateTime.now().plusMinutes(30));  // Set a reservation time

        ride.addVisitorToQueue(visitor1);
        
        // Run the ride for one cycle
        ride.runOneCycle();
        
        // Print the ride history
        ride.printRideHistory();
    }

    // Part 6: Integrate with health platform and wearable devices
    public void partSix() {
        // Create HealthPlatform and WearableDevice API objects
        HealthPlatformAPI healthAPI = new HealthPlatformAPIImpl();
        WearableDeviceAPI wearableAPI = new WearableDeviceAPIImpl();

        // Create a visitor object
        Visitor visitor1 = new Visitor("Wang Wei", 40, "Male", 2023, "wangwei@example.cn");

        // Simulate fetching health data
        int heartRate = healthAPI.getHeartRate(visitor1.getName());
        double bloodPressure = wearableAPI.getBloodPressure(visitor1.getName());
        double oxygenLevel = wearableAPI.getOxygenLevel(visitor1.getName());

        // Output the health data
        System.out.println("Visitor: " + visitor1.getName());
        System.out.println("Heart Rate: " + heartRate + " bpm");
        System.out.println("Blood Pressure: " + bloodPressure);
        System.out.println("Oxygen Level: " + oxygenLevel + "%");

        // Create Ride object and run the ride for one cycle
        Employee emp = new Employee("Li Mei", 30, "Female", "Ride Operator", 1001);
        Ride ride = new Ride("Dragon Roller Coaster", 10, emp, healthAPI, wearableAPI);
        ride.addVisitorToQueue(visitor1);
        ride.runOneCycle();
        ride.printRideHistory();
    }

    // Part 7: Data visualization and report generation
    public void partSeven() {
        // Using the same Ride object
        Employee emp = new Employee("Li Mei", 30, "Female", "Ride Operator", 1001);
        HealthPlatformAPI healthAPI = new HealthPlatformAPIImpl();
        WearableDeviceAPI wearableAPI = new WearableDeviceAPIImpl();
        
        Ride ride = new Ride("Dragon Roller Coaster", 10, emp, healthAPI, wearableAPI);

        // Create visitors and add them to the queue
        Visitor visitor1 = new Visitor("Wang Wei", 40, "Male", 2023, "wangwei@example.cn");
        Visitor visitor2 = new Visitor("Zhang Wei", 25, "Female", 2024, "zhangwei@example.cn");
        Visitor visitor3 = new Visitor("Li Ming", 30, "Male", 2025, "liming@example.cn");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        
        // Run the ride for one cycle
        ride.runOneCycle();
        
        // Visualize the ride data
        ride.visualizeData();
        
        // Generate a detailed report
        ride.generateReport("RideReport.txt");
    }
}

