package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingTicket, Car> cars = new HashMap<>();//使用map来存储车和停车票
    private int capacity = 10;

    public ParkingLot() {}

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (cars.size() >= capacity) {
            throw new IllegalStateException("Not enough position.");
        }
        if (car == null) {
            throw new NullPointerException();
        }
        if (cars.containsValue(car)) {
            throw new IllegalArgumentException("Can not passing a parked car.");
        }
        ParkingTicket parkingTicket = new ParkingTicket();
        cars.put(parkingTicket, car);
        return parkingTicket;
    }

    public Car fetchCar(ParkingTicket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Please provide your parking ticket.");
        }
        Car car = cars.remove(ticket);
        if (car == null) {
            throw new IllegalArgumentException("Unrecognized parking ticket.");
        }
        return car;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int availablePositionsCount() {
        return capacity - cars.size();
    }
}
