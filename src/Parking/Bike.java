package Parking;

public class Bike extends Vehicle {

    public Bike(String number) {
        super(number);
    }

    @Override
    public double calculateFee(long hours) {
        return hours * 20;
    }
}