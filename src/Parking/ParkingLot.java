package Parking;

import Parking.exceptions.*;   // IMPORTANT

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class ParkingLot {

    private List<ParkingSpot> spots = new ArrayList<>();
    private Map<Integer, Ticket> activeTickets = new HashMap<>();
    private int ticketCounter = 1;

    // Constructor
    public ParkingLot(int capacity) {
        for (int i = 1; i <= capacity; i++) {
            spots.add(new ParkingSpot(i));
        }
    }

    // Park Vehicle
    public Ticket parkVehicle(Vehicle v) throws ParkingFullException {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                spot.occupy();

                Ticket ticket = new Ticket(ticketCounter++, v, spot);
                activeTickets.put(ticket.getTicketId(), ticket);

                return ticket;
            }
        }
        throw new ParkingFullException("Parking Full!");
    }

    // Exit Vehicle
    public double exitVehicle(int ticketId) throws InvalidTicketException {
        if (!activeTickets.containsKey(ticketId)) {
            throw new InvalidTicketException("Invalid Ticket!");
        }

        Ticket ticket = activeTickets.remove(ticketId);
        ticket.getSpot().free();

        long hours = Duration.between(
                ticket.getEntryTime(),
                LocalDateTime.now()
        ).toHours();

        if (hours == 0) hours = 1;

        return ticket.getVehicle().calculateFee(hours);
    }

    // Display Status
    public void displayStatus() {
        long free = spots.stream().filter(ParkingSpot::isAvailable).count();
        long occupied = spots.size() - free;

        System.out.println("\n--- Parking Status ---");
        System.out.println("Total Spots: " + spots.size());
        System.out.println("Occupied: " + occupied);
        System.out.println("Available: " + free);
    }
}