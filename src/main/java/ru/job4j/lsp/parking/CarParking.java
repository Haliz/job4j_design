package ru.job4j.lsp.parking;

public class CarParking implements Parking {

    private final int spacesForPassengerCar;
    private final int spacesForTruck;
    private final Vehicles[] cars;
    private int occupiedCarSpaces = 0;
    private int occupiedTruckSpaces = 0;
    int i = 0;

    public CarParking(int spacesForPassengerCar, int spacesForTruck) {
        this.spacesForPassengerCar = spacesForPassengerCar;
        this.spacesForTruck = spacesForTruck;
        this.cars = new Cars[spacesForPassengerCar + spacesForTruck];
    }

    @Override
    public boolean parking(Vehicles vehicles) {
        int carSize = vehicles.getSize();
        if (carSize == 1 && occupiedCarSpaces < spacesForPassengerCar) {
            cars[i++] = vehicles;
            occupiedCarSpaces++;
            return true;
        } else if (carSize > 1 && occupiedTruckSpaces < spacesForTruck) {
            cars[i++] = vehicles;
            occupiedTruckSpaces++;
            return true;
        } else if (carSize > 1 && occupiedTruckSpaces == spacesForTruck
                && (occupiedCarSpaces + carSize) <= spacesForPassengerCar) {
            cars[i++] = vehicles;
            occupiedCarSpaces += carSize;
            return true;
        }
        return false;
    }

    public int getOccupiedCarSpaces() {
        return occupiedCarSpaces;
    }

    public int getOccupiedTruckSpaces() {
        return occupiedTruckSpaces;
    }
}
