package Parking;

import java.time.LocalDateTime;

public class Ticket {
    private int ticketId;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private ParkingSpot spot;

    public Ticket(int id, Vehicle v, ParkingSpot spot) {
        this.ticketId = id;
        this.vehicle = v;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSpot getSpot() {
        return spot;
    }
}