package ru.job4j.lsp.parking;

public class CarParking implements Parking {

    private int spacesForPassengerCar;
    private int spacesForTruck;
    private final Cars[] cars;
    private int occupiedCarSpaces = 0;
    private int occupiedTruckSpaces = 0;

    public CarParking(int spacesForPassengerCar, int spacesForTruck) {
        this.spacesForPassengerCar = spacesForPassengerCar;
        this.spacesForTruck = spacesForTruck;
        this.cars = new Cars[spacesForPassengerCar + spacesForTruck];
    }

    @Override
    public boolean parking(Vehicles vehicles) {
        return false;
    }

    public int getOccupiedCarSpaces() {
        return occupiedCarSpaces;
    }

    public int getOccupiedTruckSpaces() {
        return occupiedTruckSpaces;
    }
}
