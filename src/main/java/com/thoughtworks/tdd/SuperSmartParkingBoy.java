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
        ParkingLot MaxcapacityParkingLot = null;
        double bestRate = 0;  //使用比率来存储相应的可用位置率
        for (ParkingLot parkingLot : getParkingLots()) {
            double rate = parkingLot.availablePositionsCount() / parkingLot.getCapacity();
            if (MaxcapacityParkingLot == null ||
                rate > bestRate) {
                MaxcapacityParkingLot = parkingLot;
                bestRate = rate;
            }
        }
        return MaxcapacityParkingLot == null ? null : MaxcapacityParkingLot.park(car);//三目运算符，停车场为空则返回空，否则调用选出的停车场调用park获取停车票作为返回值
    }
}
