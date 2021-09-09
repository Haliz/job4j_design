package ru.job4j.lsp.parking;

public class ParkingController {

    private final Parking parking;


    public ParkingController(Parking parking) {
        this.parking = parking;
    }

    public void toParking(Vehicles vehicle) {
        parking.checkIn(vehicle);
    }
    public void fromParking(Vehicles vehicle) {
        parking.checkOut(vehicle);
    }
}
