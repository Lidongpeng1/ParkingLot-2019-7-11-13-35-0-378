package com.thoughtworks.tdd;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy() {}

    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        ParkingLot maxCapacityParkingLot = null;//设置了一停车场变量用于接收最大容量停车场信息
        for (ParkingLot parkingLot : getParkingLots()) {
            if (maxCapacityParkingLot == null ||
                parkingLot.availablePositionsCount() > maxCapacityParkingLot.availablePositionsCount()) {
                maxCapacityParkingLot = parkingLot; //遍历所有停车场获取最大容量停车场，并赋给selectedParkingLot
            }
        }
        return maxCapacityParkingLot == null ? null : maxCapacityParkingLot.park(car);//三目运算符，停车场为空则返回空，否则调用选出的停车场调用park获取停车票作为返回值
    }
}
