package com.thoughtworks.tdd;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {
    public SuperSmartParkingBoy() {}

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot selectedParkingLot = null;
        double bestRate = 0;
        for (ParkingLot parkingLot : getParkingLots()) {
            double rate = parkingLot.availablePositionsCount() / parkingLot.getCapacity();
            if (selectedParkingLot == null ||
                rate > bestRate) {
                selectedParkingLot = parkingLot;
                bestRate = rate;
            }
        }
        return selectedParkingLot == null ? null : selectedParkingLot.park(car);
    }
}
