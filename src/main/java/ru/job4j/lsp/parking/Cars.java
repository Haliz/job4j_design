package ru.job4j.lsp.parking;

public abstract class Cars implements Vehicles {
    int carSize = 1;

    @Override
    public int getSize() {
        return getCarSize();
    }

    public int getCarSize() {
        return carSize;
    }
}
