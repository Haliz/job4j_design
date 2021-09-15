package ru.job4j.lsp.parking;

public class ParkingController {

    private final Parking parking;


    public ParkingController(Parking parking) {
        this.parking = parking;
    }

    public void toParking(Vehicles vehicle) {
        parking.parking(vehicle);
    }

}
