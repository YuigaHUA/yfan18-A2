import java.time.LocalDateTime;

public class Visitor extends Person {
    private int ticketNumber;
    private String contactInfo;
    private boolean hasReservation;  // Whether the visitor has made a reservation
    private LocalDateTime reservationTime;  // Reservation time

    // Constructor with parameters
    public Visitor(String name, int age, String gender, int ticketNumber, String contactInfo) {
        super(name, age, gender);
        this.ticketNumber = ticketNumber;
        this.contactInfo = contactInfo;
        this.hasReservation = false;  // By default, no reservation
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

    public boolean hasReservation() {
        return hasReservation;
    }

    public void setReservation(boolean hasReservation) {
        this.hasReservation = hasReservation;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    // Method to cancel the reservation
    public void cancelReservation() {
        this.hasReservation = false;
        this.reservationTime = null;
    }

    // Method to make a reservation
    public void makeReservation(LocalDateTime time) {
        this.hasReservation = true;
        this.reservationTime = time;
    }
}
