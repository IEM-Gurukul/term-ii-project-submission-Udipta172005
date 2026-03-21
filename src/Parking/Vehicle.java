package Parking;

public abstract class Vehicle {
    protected String number;

    public Vehicle(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public abstract double calculateFee(long hours);
}