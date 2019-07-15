package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();//一个停车男孩可以到多个停车场停车

    public ParkingBoy() {}

    public ParkingBoy(ParkingLot parkingLot) {
        assignParkingLot(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        RuntimeException exception = null;
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.park(car);
            } catch (IllegalStateException e) {
                exception = e;
            }
        }
        if (exception != null) {
            throw exception;
        }
        return null;
    }

    public Car fetchCar(ParkingTicket ticket) { //凭停车票获取相应的汽车
        RuntimeException exception = null;
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.fetchCar(ticket);
            } catch (IllegalArgumentException e) {
                exception = e;
            }
        }
        if (exception != null) {
            throw exception;
        }
        return null;
    }

    public void assignParkingLot(ParkingLot parkingLot) {
        Objects.requireNonNull(parkingLot);
        this.parkingLots.add(parkingLot);
    }

    protected List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
