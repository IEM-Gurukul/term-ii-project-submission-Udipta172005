package Parking;

public class Car extends Vehicle {

    public Car(String number) {
        super(number);
    }

    @Override
    public double calculateFee(long hours) {
        return hours * 50;
    }
}