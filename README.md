Visitor Ride Management System
This project simulates a Visitor Ride Management System, where you can manage visitors, perform health checks, run amusement rides, and generate reports. The system integrates health data from a simulated platform and wearable devices to determine whether visitors are fit to take a ride.
Table of Contents
Project Overview
Features
Getting Started
Running the Project
Project Structure
Dependencies

Project Overview
This project simulates an amusement park's visitor management system. It includes:

Health check: Simulates checking visitor's health data like heart rate, blood pressure, and oxygen levels.
Ride management: Manages visitor queues, checks if they are fit for the ride, runs the ride, and prints ride history.
Data visualization: Visualizes visitor statistics and provides reports.
File handling: Saves and loads visitor data from files.
Key Components:
Visitor: Stores information about visitors (name, age, gender, etc.).
Health Platform and Wearable Devices: Simulate health data (heart rate, blood pressure, oxygen levels).
Ride: Manages ride operations, visitor queues, and generates ride history.
Employee: Represents the ride operator.
Features
Visitor Management: Add, remove, and manage visitors in the queue.
Health Check: Check if visitors are fit to take the ride based on simulated health data.
Ride Management: Run the ride for the visitors in the queue and maintain ride history.
Data Visualization: Visualize ride data, health check pass rates, and age distribution.
Report Generation: Generate a report of visitors' health data and ride statistics.
File Operations: Save and load visitor data from files for persistence.
Getting Started
Prerequisites
To run this project, you need:

Java (JDK 8 or higher)

You can download and install Java from here.
IDE (Optional but recommended):

Eclipse IDE
IntelliJ IDEA
Installation

Build the project:

Ensure that your Java environment is set up correctly and the project compiles without errors.
Running the Project
Once the project is set up, you can run it as follows:

Run the AssignmentTwo class:

This is the main class that contains methods for each part of the assignment (Part 3, Part 4A, Part 4B, Part 5, Part 6, Part 7).
In the main method, you can choose to run any part by uncommenting the appropriate line.
Example: To run Part 3 (health check simulation):

Uncomment the line assignment.partThree(); in the main method.
Run the program and observe the output.
Other parts: Similarly, you can run Part 4A, Part 4B, Part 5, Part 6, or Part 7 by uncommenting the corresponding lines in the main method.

Project Structure
The project is organized as follows:


Visitor-Ride-Management/
│
├── src/
│   ├── AssignmentTwo.java         # Main class with methods for each part
│   ├── Ride.java                  # Ride class for managing visitors and rides
│   ├── Visitor.java               # Visitor class for storing visitor details
│   ├── HealthPlatformAPI.java     # Interface for the health platform
│   ├── HealthPlatformAPIImpl.java # Health platform implementation
│   ├── WearableDeviceAPI.java     # Interface for the wearable device
│   └── WearableDeviceAPIImpl.java # Wearable device implementation
│
├── resources/
│   └── visitors.dat               # Example file for storing visitor data
│
└── README.md                      # Project description (this file)
Dependencies
This project is built with standard Java libraries, so there are no external dependencies. Ensure you have the JDK installed to compile and run the project.



Conclusion
The Visitor Ride Management System is a simulation of managing amusement park rides, including health checks, visitor queue management, data visualization, and report generation.
You can test and run any part of the system by uncommenting the corresponding method call in the main function.
