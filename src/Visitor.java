public class Visitor extends Person {
    private int ticketNumber;
    private String contactInfo;

    // Default constructor
    public Visitor() {
        super();
        this.ticketNumber = 0;
        this.contactInfo = "";
    }

    // Constructor with parameters
    public Visitor(String name, int age, String gender, int ticketNumber, String contactInfo) {
        super(name, age, gender);
        this.ticketNumber = ticketNumber;
        this.contactInfo = contactInfo;
    }

    // Getter and Setter methods
    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
