class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;
    private int ticketCount;

    public TicketReservationSystem() {
        this.last = null;
        this.ticketCount = 0;
    }

    // Add a new ticket reservation at the end
    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        ticketCount++;
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) return;
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last.next && current == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) last = prev;
                }
                ticketCount--;
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);
    }

    // Display all booked tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public Ticket searchTicket(String searchKey) {
        if (last == null) return null;
        Ticket temp = last.next;
        do {
            if (temp.customerName.equalsIgnoreCase(searchKey) || temp.movieName.equalsIgnoreCase(searchKey)) {
                return temp;
            }
            temp = temp.next;
        } while (temp != last.next);
        return null;
    }

    // Get total number of booked tickets
    public int getTotalTickets() {
        return ticketCount;
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "Alice", "Inception", 10, "12:00 PM");
        system.addTicket(2, "Bob", "Avatar", 15, "03:00 PM");
        system.addTicket(3, "Charlie", "Interstellar", 20, "06:00 PM");
        
        system.displayTickets();
        
        System.out.println("Total Tickets: " + system.getTotalTickets());
        system.removeTicket(2);
        
        system.displayTickets();
        System.out.println("Total Tickets: " + system.getTotalTickets());
    }
}
