package Parking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Parking System ---");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Status");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter vehicle type (car/bike): ");
                        String type = sc.next();

                        System.out.print("Enter vehicle number: ");
                        String num = sc.next();

                        Vehicle v;
                        if (type.equalsIgnoreCase("car")) {
                            v = new Car(num);
                        } else {
                            v = new Bike(num);
                        }

                        Ticket t = lot.parkVehicle(v);
                        System.out.println("Parked! Ticket ID: " + t.getTicketId());
                        break;

                    case 2:
                        System.out.print("Enter Ticket ID: ");
                        int id = sc.nextInt();

                        double fee = lot.exitVehicle(id);
                        System.out.println("Fee: ₹" + fee);
                        break;

                    case 3:
                        lot.displayStatus();
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}