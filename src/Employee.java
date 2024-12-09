public class Employee extends Person {
    private String position;
    private int employeeId;

    // Default constructor
    public Employee() {
        super();
        this.position = "";
        this.employeeId = 0;
    }

    // Constructor with parameters
    public Employee(String name, int age, String gender, String position, int employeeId) {
        super(name, age, gender);
        this.position = position;
        this.employeeId = employeeId;
    }

    // Getter and Setter methods
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
