package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();//一个停车男孩可以到多个停车场停车

    public ParkingBoy() {}

    public ParkingBoy(ParkingLot parkingLot) {  //传入特定停车场的构造函数
        assignParkingLot(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {  //传入停车场的List集合来构造函数
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {  //传入车的对象获取停车票作为返回值
        RuntimeException exception = null;
        for (ParkingLot parkingLot : parkingLots) {
            try {
                return parkingLot.park(car);  //遍历所有的停车场，如果当前停车场能够停车则返回在parkingLot获取的parkingTicket
            } catch (IllegalStateException e) {
                exception = e;
            }
        }
        if (exception != null) {   //如果捕获的异常不为空，则抛出异常
            throw exception;
        }
        return null; //如果运行到了最后说明停车依然失败，返回空
    }

    public Car fetchCar(ParkingTicket ticket) { //凭停车票获取相应的汽车
        RuntimeException exception = null;
        for (ParkingLot parkingLot : parkingLots) {  //循环遍历所有停车场
            try {
                return parkingLot.fetchCar(ticket); //所有停车场都调用fetchCar方法，查找到正确的停车票才会取车
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
        Objects.requireNonNull(parkingLot); //  如果parkinglot为空直接判空
        this.parkingLots.add(parkingLot); //在当前对象的parkingLots中添加当前停车场
    }

    protected List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
