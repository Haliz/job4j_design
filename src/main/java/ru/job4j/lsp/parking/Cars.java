package ru.job4j.lsp.parking;

public abstract class Cars implements Vehicles {
    private int carSize = 1;

    @Override
    public int getSize() {
        return carSize;
    }

    public void setSize(int carSize) {
        this.carSize = carSize;
    }
}
