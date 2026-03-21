package Parking;

public class ParkingSpot {
    private int spotId;
    private boolean isOccupied;

    public ParkingSpot(int id) {
        this.spotId = id;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    public void free() {
        isOccupied = false;
    }

    public int getSpotId() {
        return spotId;
    }
}